package com.auca.service;

import com.auca.model.Course;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CourseService {
    Course insertCourse(Course course);
    List<Course> courseList();
    void deleteCourse(Course course);
    Optional<Course> courseById(UUID id);
    Course courseByDefinitionId(UUID id);
    List<Course> courseByDepAndSem(UUID depId, UUID semId);
}
