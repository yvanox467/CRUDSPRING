package com.auca.service;

import com.auca.model.StudentCourse;

import java.util.List;
import java.util.UUID;

public interface StudentCourseService {
    StudentCourse insertStudentCourse(StudentCourse course);
    List<StudentCourse> studentCourseList();
    void deleteStudentCourse(StudentCourse course);
    List<StudentCourse> courseByStudentId(UUID id);
    List<StudentCourse> studentByCourseAndSem(UUID crId, UUID semId);
}
