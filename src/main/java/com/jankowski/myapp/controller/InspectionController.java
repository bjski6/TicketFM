package com.jankowski.myapp.controller;

import com.jankowski.myapp.repository.RepositoryPerson;
import org.springframework.stereotype.Controller;

@Controller
public class InspectionController {

    private final RepositoryPerson repositoryPerson;

    public InspectionController(RepositoryPerson repositoryPerson) {
        this.repositoryPerson = repositoryPerson;
    }


}
