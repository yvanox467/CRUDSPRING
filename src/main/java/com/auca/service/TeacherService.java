package com.auca.service;

import com.auca.model.Teacher;

import java.util.List;

public interface TeacherService {
    Teacher addTeacher(Teacher teacher);
    List<Teacher> teacherList();
    void deleteTeacher(Teacher teacher);
    Teacher findTeacherByName(String name);
}
