package myapp.controller;


import myapp.repository.RepositoryPerson;
import org.springframework.stereotype.Controller;

@Controller
public class InspectionController {

    private final RepositoryPerson repositoryPerson;

    public InspectionController(RepositoryPerson repositoryPerson) {
        this.repositoryPerson = repositoryPerson;
    }


}
