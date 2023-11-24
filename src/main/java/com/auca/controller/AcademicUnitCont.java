package com.auca.controller;

import com.auca.model.AcademicUnit;
import com.auca.model.EAcademicUnit;
import com.auca.service.AcademicUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Random;
import java.util.UUID;

@Controller
public class AcademicUnitCont {
    @Autowired
    AcademicUnitService unitService;

    int min = 10000; // Smallest 5-digit number
    int max = 99999; // Largest 5-digit number
    Random random = new Random();
    int randomCode = random.nextInt(max - min + 1) + min;

    @PostMapping("/saveParentUnit")
    public String createdUnit(@ModelAttribute AcademicUnit unit, Model model){

        unit.setId(UUID.randomUUID());
        unit.setCode(String.valueOf(randomCode));
        unit.setUnit(EAcademicUnit.PROGRAMME);

        unitService.insertUnit(unit);
        model.addAttribute("infoMessage", "saved successfully");
        return "redirect:academicUnit";
    }

    @PostMapping("/saveFacultyUnit")
    public String saveChildUnit(@ModelAttribute AcademicUnit unit, Model model){
        AcademicUnit parent = unitService.findUnitByName(unit.getParent().getName());
        int randomCode = random.nextInt(max - min + 1) + min;

        unit.setId(UUID.randomUUID());
        unit.setCode(String.valueOf(randomCode));
        unit.setUnit(EAcademicUnit.FACULTY);
        unit.setParent(parent);

        unitService.insertUnit(unit);
        model.addAttribute("infoMessage", "saved successfully");
        return "redirect:academicUnit";
    }

    @PostMapping("/saveDepartmentUnit")
    public String saveDepUnit(@ModelAttribute AcademicUnit unit, Model model){
        AcademicUnit parent = unitService.findUnitByName(unit.getParent().getName());
        int randomCode = random.nextInt(max - min + 1) + min;

        unit.setId(UUID.randomUUID());
        unit.setCode(String.valueOf(randomCode));
        unit.setUnit(EAcademicUnit.DEPARTMENT);
        unit.setParent(parent);

        unitService.insertUnit(unit);
        model.addAttribute("infoMessage", "saved successfully");
        return "redirect:academicUnit";
    }


    @GetMapping("/academicUnit")
    public String findAllUnits(Model model){
        model.addAttribute("unitList", unitService.unitList());
        model.addAttribute("programmeForm", new AcademicUnit());
        model.addAttribute("facultyForm", new AcademicUnit());
        model.addAttribute("departmentForm", new AcademicUnit());
        return "academicUnit";
    }

    @PostMapping("/deleteUnit")
    public String deleteUnit(@RequestBody AcademicUnit unit){
        unitService.deleteUnit(unit);
        return "redirect:/academicUnit";
    }

    @GetMapping("/findUnitByName")
    public String findByName(@ModelAttribute("unit") String unitName){
        unitService.findUnitByName(unitName);
        return "redirect:/academicUnit";
    }
}
