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

    @GetMapping("/user/list")
    public String listContacts(Model model) {
        List<Person> personList = repositoryPerson.findAll();
        model.addAttribute("people", personList);
        return "user/list";
    }

    @GetMapping("/user/edit/{id}")
    public String editGetPerson(@PathVariable Long id, Model model) {
        Optional<Person> person = repositoryPerson.findById(id);
        model.addAttribute("person", person);
        return "user/edit";
    }

    @PostMapping("/user/edited")
    public String editPostPerson(@ModelAttribute @Valid Person person, Company company, BindingResult result) {
        if (result.hasErrors()) {
            return "user/edit";
        }
        repositoryPerson.save(person);
        return "redirect:/user/list";
    }

    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        repositoryPerson.deleteById(id);
        return "redirect:/user/list";
    }
}
