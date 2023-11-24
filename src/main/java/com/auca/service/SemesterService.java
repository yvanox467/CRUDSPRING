package com.auca.service;

import com.auca.model.Semester;

import java.util.List;

public interface SemesterService {

    Semester addSemester(Semester semester);
    List<Semester> semesterList();
    void deleteSemester(Semester semester);
    Semester findSemesterByName(String name);
}
