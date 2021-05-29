package myapp.controller;


import myapp.model.Equipment;
import myapp.model.Installation;

import myapp.model.StatusEq;
import myapp.repository.RepositoryEquipment;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class EquipmentController {

    private final RepositoryEquipment repository;
    private final InstallationDao installationDao;
    private final EquipmentDao equipmentDao;
    private final StatusEqDao statusEqDao;


    public EquipmentController(RepositoryEquipment repository, InstallationDao installationDao, EquipmentDao equipmentDao, StatusEqDao statusEqDao) {
        this.repository = repository;
        this.installationDao = installationDao;
        this.equipmentDao = equipmentDao;
        this.statusEqDao = statusEqDao;
    }

    @GetMapping(value = "/equipment/list")
    public String listEquipment(Model model) {
        List<Equipment> equipmentList = repository.findAll();
        model.addAttribute("equipments", equipmentList);
        return "equipment/list";
    }

    @GetMapping("/equipment/add")
    public String listAddForm(Model model) {
        Equipment equipment = new Equipment();
        model.addAttribute("equipment", equipment);
        return "equipment/add";
    }

    @PostMapping("/equipment/add")
    public String addEquipment(@ModelAttribute @Valid Equipment equipment, BindingResult result,
                               Installation installation, StatusEq statusEq) {
        if (result.hasErrors()) {
            return "equipment/add";
        }
        equipmentDao.save(equipment);
        return "redirect:/equipment/list";
    }

    @GetMapping("/equipment/edit/{id}")
    public String editEquipment(@PathVariable Long id, Model model) {
        Equipment equipment = equipmentDao.findById(id);
        model.addAttribute("equipment", equipment);
        return "equipment/edit";
    }

    @PostMapping("/equipment/edited")
    public String editEquipment(@ModelAttribute @Valid Equipment equipment, BindingResult result,
                                Installation installation, StatusEq statusEq) {
        if (result.hasErrors()) {
            return "equipment/edit";
        }
        repository.save(equipment);
        return "redirect:/equipment/list";
    }

    @ModelAttribute("installations")
    public List<Installation> installations() {
        return installationDao.findAll();
    }

    @ModelAttribute("statusEq")
    public List<StatusEq> statusEq() {
        return statusEqDao.findAll();
    }

}
