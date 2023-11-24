package com.auca.service.implementation;

import com.auca.dao.TeacherDao;
import com.auca.model.Teacher;
import com.auca.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    TeacherDao teacherDao;

    @Override
    public Teacher addTeacher(Teacher teacher) {
        return teacherDao.save(teacher);
    }

    @Override
    public List<Teacher> teacherList() {
        return teacherDao.findAll();
    }

    @Override
    public void deleteTeacher(Teacher teacher) {
        teacherDao.delete(teacher);
    }

    @Override
    public Teacher findTeacherByName(String name) {
        return teacherDao.findTeacherByName(name);
    }
}
