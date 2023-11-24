package com.auca.service.implementation;

import com.auca.dao.StudentCourseDao;
import com.auca.model.StudentCourse;
import com.auca.service.StudentCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StudentCourseServiceImpl implements StudentCourseService {

    @Autowired
    StudentCourseDao studentCourseDao;

    @Override
    public StudentCourse insertStudentCourse(StudentCourse course) {
        return studentCourseDao.save(course);
    }

    @Override
    public List<StudentCourse> studentCourseList() {
        return studentCourseDao.findAll();
    }

    @Override
    public void deleteStudentCourse(StudentCourse course) {
        studentCourseDao.delete(course);
    }

    @Override
    public List<StudentCourse> courseByStudentId(UUID stId) {
        if(stId != null){
            return studentCourseDao.findStudentCourseByStudent(stId);
        }else{
            return studentCourseDao.findAll();
        }
    }

    @Override
    public List<StudentCourse> studentByCourseAndSem(UUID crId, UUID semId) {
        if(crId != null && semId != null){
            return studentCourseDao.findStudentCourseByCourseAndSemester(crId, semId);
        }else {
            return studentCourseDao.findAll();
        }
    }

}
