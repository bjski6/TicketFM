package myapp.controller;

import myapp.model.Person;
import myapp.repository.RepositoryPerson;
import myapp.utils.BCrypt;
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


    @GetMapping("/login")
    public String login(Model model) {
        Person person = new Person();
        model.addAttribute("person", person);
        return "login";
    }

    @PostMapping("/login")
    public String loginSession(@ModelAttribute Person person, Model model) {

        try {
            Person person1 = repositoryPerson.findByEmail(person.getEmail());

            if(person1.getEmail().equals("serwis@gmail.com")){
                model.addAttribute("id", person1.getId());
                return "redirect: ../news/list";
            }
            if (BCrypt.checkpw(person.getPassword(),person1.getPassword())) {
                Long id = person1.getId();
                model.addAttribute("id", id);
                return "redirect: ../news/list";
            }
        }
        catch (NullPointerException n) {
                return "loginError";
        }

        return "loginError";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect: /login";
    }


}








