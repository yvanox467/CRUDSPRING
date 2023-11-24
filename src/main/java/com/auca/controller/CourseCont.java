package com.auca.controller;

import com.auca.model.*;
import com.auca.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@Controller
public class CourseCont {
    @Autowired
    CourseService courseService;
    @Autowired
    CourseDefinitionService definitionService;
    @Autowired
    SemesterService semesterService;
    @Autowired
    TeacherService teacherService;
    @Autowired
    AcademicUnitService unitService;

    @PostMapping("/saveCourse")
    public String saveCourse(@ModelAttribute Course course, @RequestParam String action){

        if (action.equals("Update")) {
            UUID id = course.getId();
            course.setId(id);
            courseService.insertCourse(course);
        } else if (action.equals("Submit")) {
            course.setId(UUID.randomUUID());
            courseService.insertCourse(course);
        } else {
            UUID id = course.getId();
            course.setId(id);
            courseService.deleteCourse(course);
        }
        return "redirect:courseMain";
    }

    @GetMapping("/courseMain")
    public String findAllCourses(Model model){
        model.addAttribute("courseList", courseService.courseList());
        model.addAttribute("definitionList", definitionService.courseDefinitionList());
        model.addAttribute("semesterList", semesterService.semesterList());
        model.addAttribute("teacherList", teacherService.teacherList());
        model.addAttribute("unitList", unitService.unitList());
        model.addAttribute("courseForm", new Course());
        return "courseMain";
    }

    @PostMapping("/courseById")
    public String courseById(@ModelAttribute UUID id){
        Optional<Course> course = courseService.courseById(id);
        return "redirect:courseMain";
    }

    @PostMapping("/courseByDefId")
    public String courseByDefId(@ModelAttribute UUID defId){
        Course course = courseService.courseByDefinitionId(defId);
        return "redirect:CourseMain";
    }
}
