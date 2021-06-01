package myapp.controller;

import myapp.model.*;
import myapp.repository.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class TicketController {

    private final RepositoryTicket repositoryTicket;
    private final RepositoryPerson repositoryPerson;
    private final RepositoryCompany repositoryCompany;
    private final RepositoryTicketType repositoryTicketType;
    private final RepositoryInstallation repositoryInstallation;
    private final RepositoryTicketStatus repositoryTicketStatus;

    public TicketController(RepositoryTicket repositoryTicket, RepositoryPerson repositoryPerson, RepositoryCompany repositoryCompany, RepositoryTicketType repositoryTicketType, RepositoryInstallation repositoryInstallation, RepositoryTicketStatus repositoryTicketStatus) {
        this.repositoryTicket = repositoryTicket;
        this.repositoryPerson = repositoryPerson;
        this.repositoryCompany = repositoryCompany;
        this.repositoryTicketType = repositoryTicketType;
        this.repositoryInstallation = repositoryInstallation;
        this.repositoryTicketStatus = repositoryTicketStatus;
    }


    @GetMapping("/ticket/list")
    public String listTicket(Model model) {
        List<Ticket> tickets = repositoryTicket.findAll();
        model.addAttribute("tickets", tickets);
        return "ticket/list";

    }

    @GetMapping("/ticket/add")
    public String addFormTicket(Model model) {
        Ticket ticket = new Ticket();
        model.addAttribute("ticket", ticket);
        return "ticket/add";
    }

    @PostMapping("/ticket/add")
    public String addTicket(@ModelAttribute @Valid Ticket ticket, BindingResult result, HttpSession session) {
        if (result.hasErrors()) {
            return "ticket/add";
        }
        ticket.prePersist();
        ticket.setLocalDate();
        ticket.setFormatDate();
        Optional<Person> person = repositoryPerson.findById((Long) session.getAttribute("id"));
        ticket.setPersonTicket(person.get());
        Optional<Person> defaultPerson = repositoryPerson.findById(5L);
        ticket.setPersonResponsibleTicket(defaultPerson.get());
        Optional<TicketStatus> defaultStatus = repositoryTicketStatus.findById(1L);
        ticket.setTicketStatus(defaultStatus.get());
        repositoryTicket.save(ticket);
        return "redirect: /ticket/list";
    }

    @GetMapping("/ticket/details/{id}")
    public String detailsTicket (@PathVariable Long id, Model model){
        Optional<Ticket> ticket = repositoryTicket.findById(id);
        model.addAttribute("ticket", ticket.get());
        return "ticket/details";
    }

    @GetMapping("/ticket/edit/{id}")
    public String editTicket(@PathVariable Long id, Model model) {
        Optional<Ticket> ticket = repositoryTicket.findById(id);
        model.addAttribute("ticket", ticket.get());
        return "ticket/edit";
    }

    @PostMapping("ticket/edited")
    public String editedTicket(@ModelAttribute Ticket ticket){
        repositoryTicket.save(ticket);
        return "redirect: /ticket/list";
    }



    @ModelAttribute("companyList")
    public List<Company> companyList() {
        return repositoryCompany.findAll();
    }

    @ModelAttribute("ticketTypeList")
    public List<TicketType> ticketTypeList() {
        return repositoryTicketType.findAll();
    }

    @ModelAttribute("installationList")
    public List<Installation> installationList() {
        return repositoryInstallation.findAll();
    }

    @ModelAttribute("ticketStatusList")
    public List<TicketStatus> ticketStatusList(){
        return repositoryTicketStatus.findAll();
    }

    @ModelAttribute("personList")
    public List<Person> personList(){
        return repositoryPerson.findAll();
    }

}
