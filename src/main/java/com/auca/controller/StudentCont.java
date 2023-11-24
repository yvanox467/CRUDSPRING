package com.auca.controller;

import com.auca.model.Student;
import com.auca.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
public class StudentCont {
    @Autowired
    StudentService studentService;

    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute Student student, @RequestParam String action){
        if(action.equals("Update")){
            UUID id = student.getId();
            student.setId(id);
            studentService.insertStudent(student);
        }else if(action.equals("Submit")){
            student.setId(UUID.randomUUID());
            studentService.insertStudent(student);
        }else{
            UUID id = student.getId();
            student.setId(id);
            studentService.deleteStudent(student);
        }

        return "redirect:student";
    }

    @GetMapping("/student")
    public String allStudents(Model model){
        model.addAttribute("studentList", studentService.studentList());
        model.addAttribute("studentForm", new Student());
        return "student";
    }
    
    @PostMapping("/studentByRegNo")
    public String studentByRegNo(@ModelAttribute String regNo){
        studentService.findStudentByRegNo(regNo);
        return "redirect:student";
    }
}
