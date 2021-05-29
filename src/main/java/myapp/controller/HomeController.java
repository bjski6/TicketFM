package myapp.controller;

import myapp.model.Company;
import myapp.model.Permission;
import myapp.model.Person;
import myapp.repository.RepositoryPerson;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes("id")
//Gdzie zapisuje sesję- spytaj!!
public class HomeController {

    private final RepositoryPerson repositoryPerson;

    public HomeController(RepositoryPerson repositoryPerson) {
        this.repositoryPerson = repositoryPerson;
    }


    @GetMapping("/home/login")
   public String login(Model model) {
        Person person = new Person();
        model.addAttribute("person",person);
        return "home/login";
    }

    @PostMapping("home/logged")
    public String loginSession(@ModelAttribute Person person, Model model) {
        System.out.println("-----------------------------------" + person.getEmail());
        Person person1 = repositoryPerson.findByEmail(person.getEmail());
        if (person1.getPassword().equals(person.getPassword())) {
            Long id = person1.getId();
            model.addAttribute("id",id);
         return "redirect: ../news/list";
        }
        return "home/login";

    }


}



