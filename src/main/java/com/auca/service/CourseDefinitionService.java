package com.auca.service;

import com.auca.model.CourseDefinition;

import java.util.List;

public interface CourseDefinitionService {
    CourseDefinition addCourseDefinition(CourseDefinition definition);
    List<CourseDefinition> courseDefinitionList();
    void deleteDefinition(CourseDefinition definition);
    CourseDefinition findUnitByName(String name);
}
