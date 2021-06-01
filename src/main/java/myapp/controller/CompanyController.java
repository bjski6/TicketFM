package myapp.controller;

import myapp.model.Company;
import myapp.model.CompanyType;
import myapp.repository.RepositoryCompany;
import myapp.repository.RepositoryCompanyType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class CompanyController {

    private final RepositoryCompany repositoryCompany;
    private final RepositoryCompanyType repositoryCompanyType;

    public CompanyController(RepositoryCompany repositoryCompany, RepositoryCompanyType repositoryCompanyType) {
        this.repositoryCompany = repositoryCompany;
        this.repositoryCompanyType = repositoryCompanyType;
    }

    @GetMapping("company/list")
    private String listCompany(Model model) {
        List<Company> companyList = repositoryCompany.findAll();
        model.addAttribute("company", companyList);
        return "company/list";
    }


    @GetMapping("/company/add")
    private String listAddCompany(Model model) {
        Company company = new Company();
        model.addAttribute("company", company);
        return "company/add";
    }

    @PostMapping("/company/add")
    private String addCompany(@ModelAttribute @Valid Company company, BindingResult result, CompanyType companyType) {
        if (result.hasErrors()) {
            return "company/add";
        }
        repositoryCompany.save(company);
        return "redirect:/company/list";
    }

    @GetMapping("company/delete/{id}")
    public String deleteCompany(@PathVariable Long id) {
        repositoryCompany.deleteById(id);
        return "redirect:/company/list";
    }

    @ModelAttribute("companyType")
    public List<CompanyType> companyTypeList() {
        return repositoryCompanyType.findAll();
    }
}




