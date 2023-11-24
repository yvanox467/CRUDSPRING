package com.auca.controller;

import com.auca.model.CourseDefinition;
import com.auca.service.CourseDefinitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Random;
import java.util.UUID;

@Controller
public class CourseDefCont {
    @Autowired
    CourseDefinitionService definitionService;

    int min = 10000; // Smallest 5-digit number
    int max = 99999; // Largest 5-digit number
    Random random = new Random();
    int randomCode = random.nextInt(max - min + 1) + min;

    @PostMapping("/saveDefinition")
    public String saveCourseDefinition(@ModelAttribute CourseDefinition definition, @RequestParam String action){
        definition.setCode(String.valueOf(randomCode));

        if(action.equals("Update")){
            UUID id = definition.getId();
            definition.setId(id);
            definitionService.addCourseDefinition(definition);
        }else if(action.equals("Submit")){
            definition.setId(UUID.randomUUID());
            definitionService.addCourseDefinition(definition);
        }else{
            UUID id = definition.getId();
            definition.setId(id);
            definitionService.deleteDefinition(definition);
        }

        return "redirect:courses";
    }

    @GetMapping("/courses")
    public String findAllDefinitions(Model model){
        model.addAttribute("definitionList", definitionService.courseDefinitionList());
        model.addAttribute("defForm", new CourseDefinition());
        return "courses";
    }

    @PostMapping("/definitionByName")
    public String definitionByName(@ModelAttribute String defName){
        CourseDefinition definition = definitionService.findUnitByName(defName);
        return "redirect:courses";
    }
}
