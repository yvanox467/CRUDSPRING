package com.auca.service.implementation;


import com.auca.dao.CourseDefinitionDao;
import com.auca.model.CourseDefinition;
import com.auca.service.CourseDefinitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseDefinitionServiceImpl implements CourseDefinitionService {

    @Autowired
    CourseDefinitionDao definitionDao;

    @Override
    public CourseDefinition addCourseDefinition(CourseDefinition definition) {
        return definitionDao.save(definition);
    }

    @Override
    public List<CourseDefinition> courseDefinitionList() {
        return definitionDao.findAll();
    }

    @Override
    public void deleteDefinition(CourseDefinition definition) {
        definitionDao.delete(definition);
    }

    @Override
    public CourseDefinition findUnitByName(String name) {
        return definitionDao.findCourseDefinitionByName(name);
    }
}
