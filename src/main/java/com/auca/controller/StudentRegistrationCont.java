package com.auca.controller;

import com.auca.model.ERegistrationStatus;
import com.auca.model.StudentRegistration;
import com.auca.service.AcademicUnitService;
import com.auca.service.SemesterService;
import com.auca.service.StudentRegistrationService;
import com.auca.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
public class StudentRegistrationCont {
    @Autowired
    StudentRegistrationService registrationService;
    @Autowired
    StudentService studentService;
    @Autowired
    AcademicUnitService unitService;
    @Autowired
    SemesterService semesterService;

    @PostMapping("/saveRegistration")
    public String saveRegistration(@ModelAttribute StudentRegistration registration, @RequestParam String action){
        registration.setStatus(ERegistrationStatus.ADMITTED);
        if(action.equals("Update")){
            UUID id = registration.getId();
            registration.setId(id);
            registrationService.createStudentRegistration(registration);
        }else if(action.equals("Submit")){
            registration.setId(UUID.randomUUID());
            registrationService.createStudentRegistration(registration);
        }else{
            UUID id = registration.getId();
            registration.setId(id);
            registrationService.deleteStudentRegistration(registration);
        }

        return "redirect:studentRegistration";
    }

    @GetMapping("/studentRegistration")
    public String findAllRegistrations(Model model){
        model.addAttribute("registrationList", registrationService.registrationList());
        model.addAttribute("regForm", new StudentRegistration());
        model.addAttribute("studentList", studentService.studentList());
        model.addAttribute("unitList", unitService.unitList());
        model.addAttribute("semList", semesterService.semesterList());

        return "studentRegistration";
    }
}
