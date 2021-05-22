package com.jankowski.myapp.controller;

import com.jankowski.myapp.repository.RepositoryPerson;
import org.springframework.stereotype.Controller;

@Controller
public class PersonController {

    private final RepositoryPerson repositoryPerson;

    public PersonController(RepositoryPerson repositoryPerson) {
        this.repositoryPerson = repositoryPerson;
    }


}
