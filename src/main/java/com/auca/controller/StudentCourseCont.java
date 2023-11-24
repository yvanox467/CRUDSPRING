package com.auca.controller;

import com.auca.model.StudentCourse;
import com.auca.service.CourseService;
import com.auca.service.StudentCourseService;
import com.auca.service.StudentRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
public class StudentCourseCont {
    @Autowired
    StudentCourseService stCourseService;
    @Autowired
    StudentRegistrationService registrationService;
    @Autowired
    CourseService courseService;

    @PostMapping("/saveStCourse")
    public String saveStudentCourse(@ModelAttribute StudentCourse course, @RequestParam String action){
        if(action.equals("Update")){
            UUID id = course.getId();
            course.setId(id);
            stCourseService.insertStudentCourse(course);
        }else if(action.equals("Submit")){
            course.setId(UUID.randomUUID());
            stCourseService.insertStudentCourse(course);
        }else{
            UUID id = course.getId();
            course.setId(id);
            stCourseService.deleteStudentCourse(course);
        }
        return "redirect:studentCourse";
    }

    @GetMapping("/studentCourse")
    public String findAllStCourses(Model model){
        model.addAttribute("stCourseList", stCourseService.studentCourseList());
        model.addAttribute("stCourseForm", new StudentCourse());
        model.addAttribute("registrationList", registrationService.registrationList());
        model.addAttribute("courseList", courseService.courseList());

        return "studentCourse";
    }
}
