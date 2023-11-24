package com.auca.service.implementation;

import com.auca.dao.StudentRegistrationDao;
import com.auca.model.StudentRegistration;
import com.auca.service.StudentRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StudentRegistrationServiceImpl implements StudentRegistrationService {

    @Autowired
    StudentRegistrationDao registrationDao;

    @Override
    public StudentRegistration createStudentRegistration(StudentRegistration registration) {
        return registrationDao.save(registration);
    }

    @Override
    public List<StudentRegistration> registrationList() {
        return registrationDao.findAll();
    }

    @Override
    public void deleteStudentRegistration(StudentRegistration registration) {
        registrationDao.delete(registration);
    }

    @Override
    public List<StudentRegistration> getStudentBySemesterId(UUID id) {
        if(id != null) {
            return registrationDao.findStudentRegistrationBySemesterId(id);
        }else{
            return registrationDao.findAll();
        }
    }

    @Override
    public List<StudentRegistration> getStudentBySemesterAndDepartment(UUID id, UUID unitId) {
        if(id != null && unitId != null){
            return registrationDao.findStudentRegistrationBySemesterIdAndUnitId(id, unitId);
        }else{
            return registrationDao.findAll();
        }
    }
}
