package com.auca.controller;

import com.auca.model.Semester;
import com.auca.service.SemesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
public class SemesterCont {
    @Autowired
    SemesterService semesterService;

    @PostMapping("/saveSemester")
    public String saveSemester(@ModelAttribute Semester semester, Model model, @RequestParam String action){
        if(action.equals("Update")){
            UUID id = semester.getId();
            semester.setId(id);
            semesterService.addSemester(semester);
        }else if(action.equals("Submit")){
            semester.setId(UUID.randomUUID());
            semesterService.addSemester(semester);
        }else{
            UUID id = semester.getId();
            semester.setId(id);
            semesterService.deleteSemester(semester);
        }

        model.addAttribute("infoMessage", "Request successfully");
        return "redirect:semester";
    }

    @GetMapping("/semester")
    public String listSemesters(Model model){
        model.addAttribute("semesterList", semesterService.semesterList());
        model.addAttribute("semForm", new Semester());
        return "semester";
    }

    @PostMapping("/findSemByName")
    public String findSemByName(@RequestBody String semName){
        Semester semester = semesterService.findSemesterByName(semName);
        return "redirect:semester";
    }
}
