package myapp.controller;

import myapp.repository.RepositoryPerson;
import org.springframework.stereotype.Controller;

@Controller
public class TicketsController {

    private final RepositoryPerson repositoryPerson;

    public TicketsController(RepositoryPerson repositoryPerson) {
        this.repositoryPerson = repositoryPerson;
    }


}
