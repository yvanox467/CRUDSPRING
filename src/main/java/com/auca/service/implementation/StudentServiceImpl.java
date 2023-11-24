package com.auca.service.implementation;

import com.auca.dao.StudentDao;
import com.auca.model.Student;
import com.auca.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentDao studentDao;

    @Override
    public Student insertStudent(Student student) {
        return studentDao.save(student);
    }

    @Override
    public List<Student> studentList() {
        return studentDao.findAll();
    }

    @Override
    public void deleteStudent(Student student) {
        studentDao.delete(student);
    }

    @Override
    public Student findStudentByRegNo(String regNo) {
        return studentDao.findStudentByRegNo(regNo);
    }
}
