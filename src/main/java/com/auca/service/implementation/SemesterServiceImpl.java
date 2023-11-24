package com.auca.service.implementation;

import com.auca.dao.SemesterDao;
import com.auca.model.Semester;
import com.auca.service.SemesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SemesterServiceImpl implements SemesterService {

    @Autowired
    SemesterDao semesterDao;

    @Override
    public Semester addSemester(Semester semester) {
        return semesterDao.save(semester);
    }

    @Override
    public List<Semester> semesterList() {
        return semesterDao.findAll();
    }

    @Override
    public void deleteSemester(Semester semester) {
        semesterDao.delete(semester);
    }

    @Override
    public Semester findSemesterByName(String name) {
        return semesterDao.findSemesterByName(name);
    }
}
