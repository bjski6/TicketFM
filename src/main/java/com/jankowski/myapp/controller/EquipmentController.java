package com.jankowski.myapp.controller;

import com.jankowski.myapp.repository.RepositoryEquipment;
import com.jankowski.myapp.model.Equipment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EquipmentController {

    private final RepositoryEquipment repository;

    public EquipmentController(RepositoryEquipment repository) {
        this.repository = repository;
    }

    @GetMapping(value = "/equipment/list")
    public String listEquipment(Model model) {
        List<Equipment> equipmentList = repository.findAll();
        model.addAttribute("equipments", equipmentList);
        return "/equipment/list";
    }

    @GetMapping("/equipment/add")
    public String listForm(Model model) {
        Equipment equipment = new Equipment();
        model.addAttribute("equipment", equipment);
        return "equipment/add";
    }

    @PostMapping("/equipment/add")
    public String addEquipment (@ModelAttribute Equipment equipment, BindingResult result){
        repository.save(equipment);
        return "redirect:/equipment/list";
    }
}
