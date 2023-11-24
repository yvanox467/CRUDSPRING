package com.auca.service;

import com.auca.model.StudentRegistration;

import java.util.List;
import java.util.UUID;

public interface StudentRegistrationService {
    StudentRegistration createStudentRegistration(StudentRegistration registration);
    List<StudentRegistration> registrationList();
    void deleteStudentRegistration(StudentRegistration registration);

    List<StudentRegistration> getStudentBySemesterId(UUID id);

    List<StudentRegistration> getStudentBySemesterAndDepartment(UUID id, UUID unitId);
}
