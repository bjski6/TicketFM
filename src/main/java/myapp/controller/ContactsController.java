package myapp.controller;


import myapp.model.Company;
import myapp.model.Person;
import myapp.repository.RepositoryPerson;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class ContactsController {

    private final RepositoryPerson repositoryPerson;

    public ContactsController(RepositoryPerson repositoryPerson) {
        this.repositoryPerson = repositoryPerson;
    }

    @GetMapping("start/contact/list")
    private String listContacts (Model model){
        List<Person> personList = repositoryPerson.findAll();
        model.addAttribute("people", personList);
        return "start/contact/list";
    }

    @GetMapping("/start/contact/edit/{id}")
    private String editGetPerson (@PathVariable Long id, Model model){
        Optional<Person> person = repositoryPerson.findById(id);
        model.addAttribute("person", person);
        return "start/contact/edit";
    }

    @PostMapping("/start/contact/edit")
    private String editPostPerson (@ModelAttribute @Valid Person person, Company company, BindingResult result){
        if(result.hasErrors()){
            return "start/contact/edit";
        }
        repositoryPerson.save(person);
        return "redirect:/start/contact/list";
    }
}
