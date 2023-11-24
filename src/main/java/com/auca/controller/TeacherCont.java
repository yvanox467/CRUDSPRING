package com.auca.controller;

import com.auca.model.Teacher;
import com.auca.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Random;
import java.util.UUID;

@Controller
public class TeacherCont {
    @Autowired
    TeacherService teacherService;

    int min = 10000; // Smallest 5-digit number
    int max = 99999; // Largest 5-digit number
    Random random = new Random();
    int randomCode = random.nextInt(max - min + 1) + min;

    @PostMapping("/saveTeacher")
    public String saveTeacher(@ModelAttribute Teacher teacher, @RequestParam String action){
        teacher.setCode(String.valueOf(randomCode));
        
        if(action.equals("Update")){
            UUID id = teacher.getId();
            teacher.setId(id);
            teacherService.addTeacher(teacher);
        }else if(action.equals("Submit")){
            teacher.setId(UUID.randomUUID());
            teacherService.addTeacher(teacher);
        }else{
            UUID id = teacher.getId();
            teacher.setId(id);
            teacherService.deleteTeacher(teacher);
        }
        return "redirect:teachers";
    }

    @GetMapping("/teachers")
    public String allTeachers(Model model){
        model.addAttribute("teacherList", teacherService.teacherList());
        model.addAttribute("teacherForm", new Teacher());
        return "teachers";
    }

    @PostMapping("/teacherByName")
    public String teacherByName(@ModelAttribute String name){
        teacherService.findTeacherByName(name);
        return "redirect:teachers";
    }
}
