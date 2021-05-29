package myapp.controller;


import myapp.model.News;
import myapp.model.Person;
import myapp.repository.RepositoryNews;
import myapp.repository.RepositoryPerson;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class NewsController {

    private final RepositoryNews repositoryNews;
    private final RepositoryPerson repositoryPerson;

    public NewsController(RepositoryNews repositoryNews, RepositoryPerson repositoryPerson) {
        this.repositoryNews = repositoryNews;
        this.repositoryPerson = repositoryPerson;
    }

    @GetMapping("news/list")
    public String listNews(Model model) {
        List<News> newsList = repositoryNews.findAll();
        model.addAttribute("news", newsList);
        return "news/list";
    }

    @GetMapping("news/add")
    public String listNewsForm(Model model, HttpSession session) {
        News news = new News();
        model.addAttribute("news", news);
        return "news/add";
    }

    @PostMapping("news/add")
    public String addNews(@ModelAttribute @Valid News news, BindingResult result, HttpSession session) {
        if (result.hasErrors()) {
            return "news/add";
        }

        news.prePersist();
        news.setFormatDate();
        Optional<Person> person = repositoryPerson.findById((Long) session.getAttribute("id"));
        news.setPersonNews(person.get());
        System.out.println(person.get().toString());

        repositoryNews.save(news);
        return "redirect: /news/list";
    }


}
