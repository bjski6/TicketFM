package myapp.controller;


import myapp.model.News;
import myapp.model.Person;
import myapp.repository.RepositoryNews;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class NewsController {

    private final RepositoryNews repositoryNews;

    public NewsController(RepositoryNews repositoryNews) {
        this.repositoryNews = repositoryNews;
    }

    @GetMapping("news/list")
    public String listNews(Model model) {
        List<News> newsList = repositoryNews.findAll();
        model.addAttribute("news", newsList);
        return "news/list";
    }

    @GetMapping("news/add")
    public String listNewsForm(Model model) {
        News news = new News();
        model.addAttribute("news", news);
        return "news/add";
    }

    @PostMapping("news/add")
    public String addNews(@ModelAttribute @Valid News news, BindingResult result) {
        if (result.hasErrors()) {
            return "news/add";
        }

        news.prePersist();

        //wyciagnac uzytkownika z sesji i dodac do newsa
        repositoryNews.save(news);
        return "redirect: /news/list";
    }


}
