package com.auca.service.implementation;

import com.auca.dao.CourseDao;
import com.auca.model.Course;
import com.auca.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseDao courseDao;

    @Override
    public Course insertCourse(Course course) {
        return courseDao.save(course);
    }

    @Override
    public List<Course> courseList() {
        return courseDao.findAll();
    }

    @Override
    public void deleteCourse(Course course) {
        courseDao.delete(course);
    }

    @Override
    public Optional<Course> courseById(UUID id) {
        return courseDao.findById(id);
    }

    @Override
    public Course courseByDefinitionId(UUID id) {
        return null;
    }

    @Override
    public List<Course> courseByDepAndSem(UUID depId, UUID semId) {
        if(depId != null && semId != null) {
            return courseDao.findCourseByDepartmentIdAndSemesterId(depId, semId);
        }else{
            return courseDao.findAll();
        }
    }
}
