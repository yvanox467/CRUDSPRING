package com.auca.controller;

import com.auca.model.Course;
import com.auca.model.Student;
import com.auca.model.StudentCourse;
import com.auca.model.StudentRegistration;
import com.auca.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
public class ListCont {
    @Autowired
    StudentRegistrationService registrationService;
    @Autowired
    SemesterService semesterService;
    @Autowired
    AcademicUnitService unitService;
    @Autowired
    CourseDefinitionService definitionService;
    @Autowired
    StudentCourseService courseService;
    @Autowired
    CourseService crService;
    @Autowired
    StudentService studentService;


    @GetMapping("/studentPerSem")
    public String studentPerSem(Model model, @RequestParam(name = "semester.id", required = false) String semesterId) {
        UUID id = null;
        if(semesterId != null) {
            id = UUID.fromString(semesterId);
        }
        model.addAttribute("semesterList", semesterService.semesterList());
        model.addAttribute("studentList", registrationService.getStudentBySemesterId(id));
        model.addAttribute("stFindForm", new StudentRegistration());

        return "studentPerSem";
    }

    @GetMapping("/studentPerDepAndSem")
    public String studentPerDepAndSem(Model model, @RequestParam(name="unit.id", required = false) String depId, @RequestParam(name="semester.id", required = false) String semId){
        UUID dId = null; UUID sId = null;

        if(depId != null && semId != null){
            dId = UUID.fromString(depId);
            sId = UUID.fromString(semId);
        }

        model.addAttribute("departmentList", unitService.unitList());
        model.addAttribute("semesterList", semesterService.semesterList());
        model.addAttribute("studentList", registrationService.getStudentBySemesterAndDepartment(sId, dId));
        model.addAttribute("depNSemForm", new StudentRegistration());

        return "studentPerDepAndSem";
    }

    @GetMapping("StudentPerCourseAndSem")
    public String studentPerCourseAndSem(Model model, @RequestParam(name="course.courseDefinition.id", required = false) String courseId, @RequestParam(name="course.semester.id", required = false) String semId){
        UUID crId = null; UUID sId = null;

        System.out.println(courseId);

        if(courseId != null && semId != null){
            crId = UUID.fromString(courseId);
            sId = UUID.fromString(semId);
        }

        model.addAttribute("courseList", crService.courseList());
        model.addAttribute("semesterList", semesterService.semesterList());
        model.addAttribute("studentList", courseService.studentByCourseAndSem(crId, sId));
        model.addAttribute("stCrSemForm", new StudentCourse());

        return "StudentPerCourseAndSem";
    }

    @GetMapping("/coursesPerDepAndSem")
    public String coursesPerDepAndSem(Model model, @RequestParam(name="department.id", required = false) String depId, @RequestParam(name="semester.id", required = false) String semId){
        UUID dId=null; UUID sId=null;

        if(depId != null && semId != null){
            dId = UUID.fromString(depId);
            sId = UUID.fromString(semId);
        }

        model.addAttribute("unitList", unitService.unitList());
        model.addAttribute("semesterList", semesterService.semesterList());
        model.addAttribute("courseList", crService.courseByDepAndSem(dId, sId));
        model.addAttribute("depSemForm", new Course());

        return "coursesPerDepAndSem";
    }

    @GetMapping("/coursesPerStudent")
    public String coursesPerStudent(Model model, @RequestParam(name="id", required = false) String stId){
        UUID sId=null;
        if(stId != null) sId = UUID.fromString(stId);

        model.addAttribute("studentList", studentService.studentList());
        model.addAttribute("courseList", courseService.courseByStudentId(sId));
        model.addAttribute("stForm", new Student());

        return "coursesPerStudent";
    }
}

