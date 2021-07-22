package myapp.controller;


import myapp.model.Company;
import myapp.model.Person;
import myapp.repository.RepositoryCompany;
import myapp.repository.RepositoryPerson;
import myapp.utils.BCrypt;
import org.springframework.orm.jpa.JpaSystemException;
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
public class UsersController {

    private final RepositoryPerson repositoryPerson;
    private final RepositoryCompany repositoryCompany;

    public UsersController(RepositoryPerson repositoryPerson, RepositoryCompany repositoryCompany) {
        this.repositoryPerson = repositoryPerson;
        this.repositoryCompany = repositoryCompany;
    }

    @GetMapping("/user/list")
    public String listContacts(Model model) {
        List<Person> personList = repositoryPerson.findAll();
        model.addAttribute("people", personList);
        return "user/list";
    }

    @GetMapping("/user/add")
    public String addFormUser(Model model){
        Person person =new Person();
        model.addAttribute("person", person);
        return "user/add";
    }

    @PostMapping("/user/add")
    public String addUser(@ModelAttribute @Valid Person person, BindingResult result){
        if(result.hasErrors()){
            return "user/add";
        }
        person.setPassword(BCrypt.hashpw(person.getPassword(), BCrypt.gensalt()));
        repositoryPerson.save(person);
        return "redirect: /user/list";
    }

    @GetMapping("contact/list")
    public String listStartContacts(Model model) {
        List<Person> personList = repositoryPerson.findAll();
        model.addAttribute("people", personList);
        return "contact/list";
    }

    @GetMapping("/user/edit/{id}")
    public String editGetPerson(@PathVariable Long id, Model model) {
        Optional<Person> person = repositoryPerson.findById(id);
        model.addAttribute("person", person);
        return "user/edit";
    }

    @PostMapping("/user/edited")
    public String editPostPerson(@ModelAttribute @Valid Person person, BindingResult result, Company company) {
        if (result.hasErrors()) {
            return "user/edit";
        }
        person.setPassword(BCrypt.hashpw(person.getPassword(), BCrypt.gensalt()));
        repositoryPerson.save(person);
        return "redirect:/user/list";
    }

    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
       try {
           repositoryPerson.deleteById(id);
       }
       catch (JpaSystemException s){
           return "deleteError";
       }
        return "redirect:/user/list";
    }


    @ModelAttribute("companyList")
    public List<Company> companyList(){
        return repositoryCompany.findAll();
    }
}
