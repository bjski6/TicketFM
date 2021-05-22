package com.jankowski.myapp.controller;

import com.jankowski.myapp.repository.RepositoryPerson;
import org.springframework.stereotype.Controller;

@Controller
public class NewsController {

    private final RepositoryPerson repositoryPerson;

    public NewsController(RepositoryPerson repositoryPerson) {
        this.repositoryPerson = repositoryPerson;
    }


}
