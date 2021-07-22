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
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Controller
public class InspectionController {

    private final RepositoryPerson repositoryPerson;
    private final RepositoryInspection repositoryInspection;
    private final RepositoryCompany repositoryCompany;
    private final RepositoryInstallation repositoryInstallation;
    private final RepositoryInspectionCycle repositoryInspectionCycle;
    private final RepositoryStatus repositoryStatus;



    public InspectionController(RepositoryPerson repositoryPerson, RepositoryInspection repositoryInspection, RepositoryCompany repositoryCompany, RepositoryInstallation repositoryInstallation, RepositoryInspectionCycle repositoryInspectionCycle, RepositoryStatus repositoryStatus) {
        this.repositoryPerson = repositoryPerson;
        this.repositoryInspection = repositoryInspection;
        this.repositoryCompany = repositoryCompany;
        this.repositoryInstallation = repositoryInstallation;
        this.repositoryInspectionCycle = repositoryInspectionCycle;
        this.repositoryStatus = repositoryStatus;
    }


    @GetMapping("/inspection/list")
    public String listInspection(Model model) {
        List<Inspection> inspections = repositoryInspection.findAll();
        inspections.sort((i1, i2) -> i1.getStartInspection().compareTo(i2.getStartInspection()));
        model.addAttribute("inspections", inspections);
        return "inspection/list";
    }


    @GetMapping("/inspection/add")
    public String addFormInspection(Model model) {
        Inspection inspection = new Inspection();
        model.addAttribute("inspection", inspection);
        return "inspection/add";
    }

    @PostMapping("inspection/add")
    public String addInspection(@ModelAttribute @Valid Inspection inspection,
                                BindingResult result, HttpSession session) {
        if (result.hasErrors()) {
            return "inspection/add";
        }
        inspection.prePersist();
        Optional<Person> person = repositoryPerson.findById((Long) session.getAttribute("id"));
        inspection.setOwnerPerson(person.get());
        Optional<Status> defaultStatus = repositoryStatus.findById(1L);
        inspection.setStatus(defaultStatus.get());
        repositoryInspection.save(inspection);
        return "redirect: /inspection/list";
    }

    @GetMapping("/inspection/edit/{id}")
    public String editInspection(@PathVariable Long id, Model model) {
        Optional<Inspection> inspection = repositoryInspection.findById(id);
        model.addAttribute("inspection", inspection.get());
        return "inspection/add";
    }

    @PostMapping("/inspection/edited")
    public String editedInspection(@ModelAttribute Inspection inspection, HttpSession session) {
        Optional<Person> person = repositoryPerson.findById((Long) session.getAttribute("id"));
        inspection.setOwnerPerson(person.get());
        return "inspection/list";
    }


    @GetMapping("/inspection/details/{id}")
    public String detailsInspection(@PathVariable Long id, Model model) {
        Optional<Inspection> inspection = repositoryInspection.findById(id);
        model.addAttribute("inspection", inspection.get());
        return "inspection/details";
    }

    @GetMapping("/inspection/generate/{id}")
    public String generateInspection(@PathVariable Long id, Model model) {
        Optional<Inspection> inspection = repositoryInspection.findById(id);
        model.addAttribute("inspection", inspection.get());
        return "inspection/generate";
    }

    @ModelAttribute("companyList")
    public List<Company> companyList() {
        return repositoryCompany.findAll();
    }

    @ModelAttribute("installationList")
    public List<Installation> installationList() {
        return repositoryInstallation.findAll();
    }

    @ModelAttribute("personList")
    public List<Person> personList() {
        return repositoryPerson.findAll();
    }

    @ModelAttribute("inspectionCycleList")
    public List<InspectionCycle> inspectionCycleList() {
        return repositoryInspectionCycle.findAll();
    }


}
