package myapp.controller;

import myapp.model.*;
import myapp.repository.*;
import myapp.utils.DateConvert;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Optional;

@Controller
public class TicketController {

    private final RepositoryTicket repositoryTicket;
    private final RepositoryPerson repositoryPerson;
    private final RepositoryCompany repositoryCompany;
    private final RepositoryTicketType repositoryTicketType;
    private final RepositoryInstallation repositoryInstallation;
    private final RepositoryStatus repositoryStatus;

    public TicketController(RepositoryTicket repositoryTicket, RepositoryPerson repositoryPerson, RepositoryCompany repositoryCompany, RepositoryTicketType repositoryTicketType, RepositoryInstallation repositoryInstallation, RepositoryStatus repositoryStatus) {
        this.repositoryTicket = repositoryTicket;
        this.repositoryPerson = repositoryPerson;
        this.repositoryCompany = repositoryCompany;
        this.repositoryTicketType = repositoryTicketType;
        this.repositoryInstallation = repositoryInstallation;
        this.repositoryStatus = repositoryStatus;
    }


    @GetMapping("/ticket/list")
    public String listTicket(Model model) {
        List<Ticket> tickets = repositoryTicket.findAll();
        tickets.sort((t1,t2) -> t1.getDateAdd().compareTo(t2.getDateAdd()));
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
        Optional<Person> person = repositoryPerson.findById((Long) session.getAttribute("id"));
        ticket.setPersonTicket(person.get());
        Optional<Person> defaultPerson = repositoryPerson.findById(1L);
        ticket.setPersonResponsibleTicket(defaultPerson.get());
        Optional<Status> defaultStatus = repositoryStatus.findById(1L);
        ticket.setStatus(defaultStatus.get());
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
    public String editedTicket(@ModelAttribute Ticket ticket, HttpSession session){
        if((ticket.getPersonResponsibleTicket().equals(repositoryPerson.findById(1L)))){
            Optional<Status> status =repositoryStatus.findById(2L);
            ticket.setStatus(status.get());
            Optional<Person> person = repositoryPerson.findById((Long) session.getAttribute("id"));
            ticket.setPersonTicket(person.get());
        }
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

    @ModelAttribute("statusList")
    public List<Status> statusList(){
        return repositoryStatus.findAll();
    }

    @ModelAttribute("personList")
    public List<Person> personList(){
        return repositoryPerson.findAll();
    }

}
