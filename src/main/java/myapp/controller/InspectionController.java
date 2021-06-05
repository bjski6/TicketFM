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
    private final RepositoryInspectionType repositoryInspectionType;


    public InspectionController(RepositoryPerson repositoryPerson, RepositoryInspection repositoryInspection, RepositoryCompany repositoryCompany, RepositoryInstallation repositoryInstallation, RepositoryInspectionCycle repositoryInspectionCycle, RepositoryStatus repositoryStatus, RepositoryInspectionType repositoryInspectionType) {
        this.repositoryPerson = repositoryPerson;
        this.repositoryInspection = repositoryInspection;
        this.repositoryCompany = repositoryCompany;
        this.repositoryInstallation = repositoryInstallation;
        this.repositoryInspectionCycle = repositoryInspectionCycle;
        this.repositoryStatus = repositoryStatus;
        this.repositoryInspectionType = repositoryInspectionType;
    }

    //lista definicji
    @GetMapping("/inspection/list")
    public String listInspection(Model model) {
        List<Inspection> inspections = repositoryInspection.findByInspectionTypeId(1);
        inspections.sort((i1, i2) -> i1.getStartInspection().compareTo(i2.getStartInspection()));

        model.addAttribute("inspections", inspections);
        return "inspection/list";
    }

    @GetMapping("/inspection/listInspection")
    public String listListInspection(Model model) {
        List<Inspection> inspections = repositoryInspection.findByInspectionTypeId(2);
        inspections.sort(Comparator.comparing(Inspection::getStartInspection));


        model.addAttribute("inspections", inspections);
        return "inspection/listInspection";
    }

    //dodaj definicje
    @GetMapping("/inspection/add")
    public String addFormInspection(Model model) {
        Inspection inspection = new Inspection();
        model.addAttribute("inspection", inspection);
        return "inspection/add";
    }

    //dodawanie definicji
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

        Optional<InspectionType> definition = repositoryInspectionType.findById(1L);
        inspection.setInspectionType(definition.get());
        try {
            inspection.setStartInspection(DateConvert.setStringToDate(inspection.getStartInspectionString()));
            inspection.setEndInspection(DateConvert.setStringToDate(inspection.getEndInspectionString()));
            inspection.setDateAddString(DateConvert.setDateToString(inspection.getDateAdd()));
        } catch (DateTimeParseException d) {
            return "timeErrorInspAdd";
        }
        if (inspection.getInspectionDuration() == null) {
            inspection.setInspectionDuration("1");
        }
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

    @PostMapping("/inspection/generate")
    public String generatedInspection(@ModelAttribute Inspection inspection, InspectionCycle inspectionCycle, HttpSession session) {
        inspection.prePersist();
        try {
            inspection.setStartInspection(DateConvert.setStringToDate(inspection.getStartInspectionString()));
            inspection.setEndInspection(DateConvert.setStringToDate(inspection.getEndInspectionString()));
            inspection.setDateAddString(DateConvert.setDateToString(inspection.getDateAdd()));
        } catch (DateTimeParseException e) {
            return "timeErrorInsp";
        }
        inspection.setInspectionCycle(inspection.getInspectionCycle());
        inspection.setInspectionCycle(repositoryInspection.findById(inspection.getId()).get().getInspectionCycle());

        Optional<InspectionType> inspectionType = repositoryInspectionType.findById(2L);
        inspection.setInspectionType(inspectionType.get());

        Optional<Person> person = repositoryPerson.findById((Long) session.getAttribute("id"));
        inspection.setOwnerPerson(person.get());

        Optional <Status> status = repositoryStatus.findById(1L);
        inspection.setStatus(status.get());

        while (inspection.getStartInspection().isBefore(inspection.getEndInspection())) {
            repositoryInspection.save(inspection);
            if (inspection.getInspectionCycle().getId().equals(1L)) {
                System.out.println("======================" + inspection);
                inspection.setStartInspection(inspection.getStartInspection().plusDays(1));
                inspection.setStartInspectionString(DateConvert.setDateToString(inspection.getStartInspection()));
                inspection.setId((long) repositoryInspection.findAll().size() + 1);
                repositoryInspection.save(inspection);
            } else if (inspection.getInspectionCycle().getId().equals(2L)) {
                System.out.println("======================" + inspection);
                inspection.setStartInspection(inspection.getStartInspection().plusWeeks(1));
                inspection.setStartInspectionString(DateConvert.setDateToString(inspection.getStartInspection()));
                inspection.setId((long) repositoryInspection.findAll().size() + 1);
                repositoryInspection.save(inspection);
            } else if (inspection.getInspectionCycle().getId().equals(3L)) {
                System.out.println("======================" + inspection);
                inspection.setStartInspection(inspection.getStartInspection().plusMonths(1));
                inspection.setStartInspectionString(DateConvert.setDateToString(inspection.getStartInspection()));
                inspection.setId((long) repositoryInspection.findAll().size() + 1);
                repositoryInspection.save(inspection);
            } else if (inspection.getInspectionCycle().getId().equals(4L)) {
                System.out.println("======================" + inspection);
                inspection.setStartInspection(inspection.getStartInspection().plusMonths(3));
                inspection.setStartInspectionString(DateConvert.setDateToString(inspection.getStartInspection()));
                inspection.setId((long) repositoryInspection.findAll().size() + 1);
                repositoryInspection.save(inspection);
            } else if (inspection.getInspectionCycle().getId().equals(5L)) {
                System.out.println("======================" + inspection);
                inspection.setStartInspection(inspection.getStartInspection().plusYears(1));
                inspection.setStartInspectionString(DateConvert.setDateToString(inspection.getStartInspection()));
                inspection.setId((long) repositoryInspection.findAll().size() + 1);
                repositoryInspection.save(inspection);
            }
        }

        return "redirect: /inspection/listInspection";


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
