package myapp.controller;


import myapp.model.Equipment;
import myapp.model.EquipmentStatus;
import myapp.model.Installation;

import myapp.repository.RepositoryEquipment;

import myapp.repository.RepositoryInstallation;
import myapp.repository.RepositoryEquipmentStatus;
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

    private final RepositoryEquipment repositoryEquipment;
    private final RepositoryInstallation repositoryInstallation;
    private final RepositoryEquipmentStatus repositoryEquipmentStatus;

    public EquipmentController(RepositoryEquipment repositoryEquipment, RepositoryInstallation repositoryInstallation, RepositoryEquipmentStatus repositoryEquipmentStatus) {
        this.repositoryEquipment = repositoryEquipment;
        this.repositoryInstallation = repositoryInstallation;
        this.repositoryEquipmentStatus = repositoryEquipmentStatus;
    }


    @GetMapping(value = "/equipment/list")
    public String listEquipment(Model model) {
        List<Equipment> equipmentList = repositoryEquipment.findAll();
        model.addAttribute("equipments", equipmentList);
        return "equipment/list";
    }

    @GetMapping("/equipment/add")
    public String addFormEquipment(Model model) {
        Equipment equipment = new Equipment();
        model.addAttribute("equipment", equipment);
        return "equipment/add";
    }

    @PostMapping("/equipment/add")
    public String addEquipment(@ModelAttribute @Valid Equipment equipment, BindingResult result,
                               Installation installation, EquipmentStatus equipmentStatus) {
        if (result.hasErrors()) {
            return "equipment/add";
        }
        repositoryEquipment.save(equipment);
        return "redirect:/equipment/list";
    }

    @GetMapping("/equipment/edit/{id}")
    public String editEquipment(@PathVariable Long id, Model model) {
        Optional <Equipment> equipment = repositoryEquipment.findById(id);
        model.addAttribute("equipment", equipment.get());
        return "equipment/edit";
    }

    @PostMapping("/equipment/edited")
    public String editEquipment(@ModelAttribute @Valid Equipment equipment, BindingResult result,
                                Installation installation, EquipmentStatus equipmentStatus) {
        if (result.hasErrors()) {
            return "equipment/edit";
        }
        repositoryEquipment.save(equipment);
        return "redirect:/equipment/list";
    }

    @ModelAttribute("installations")
    public List<Installation> installations() {
        return repositoryInstallation.findAll();
    }

    @ModelAttribute("equipmentStatus")
    public List<EquipmentStatus> equipmentStatusList() {
        return repositoryEquipmentStatus.findAll();
    }


}
