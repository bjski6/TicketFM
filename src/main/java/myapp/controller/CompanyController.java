package myapp.controller;

import myapp.model.Company;
import myapp.repository.RepositoryCompany;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class CompanyController {

    private final RepositoryCompany repositoryCompany;

    public CompanyController(RepositoryCompany repositoryCompany) {
        this.repositoryCompany = repositoryCompany;
    }

    @GetMapping("company/list")
    private String listCompany (Model model){
        List <Company> companyList = repositoryCompany.findAll();
        model.addAttribute("company",companyList);
        return "company/list";
    }

    @GetMapping("company/add")
    private String listAddCompany (Model model){
        Company company = new Company();
        model.addAttribute("company", company);
        return "company/add";
    }

    @PostMapping("company/add")
    private String addCompany (@ModelAttribute @Valid Company company, BindingResult result){
        if (result.hasErrors()) {
            return "company/add";
        }
        repositoryCompany.save(company);
        return "redirect:/company/list";
    }

    @ModelAttribute("type")
    public List<String> getType() {
        List<String> list = List.of(new String[]{"Najemca", "Właściciel", "Serwis techniczny"});
        return list;
    }
    }




