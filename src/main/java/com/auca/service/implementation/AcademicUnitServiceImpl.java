package com.auca.service.implementation;

import com.auca.dao.AcademicUnitDao;
import com.auca.model.AcademicUnit;
import com.auca.service.AcademicUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AcademicUnitServiceImpl implements AcademicUnitService {

    @Autowired
    AcademicUnitDao unitDao;

    @Override
    public AcademicUnit insertUnit(AcademicUnit unit) {
        return unitDao.save(unit);
    }

    @Override
    public List<AcademicUnit> unitList() {
        return unitDao.findAll();
    }

    @Override
    public void deleteUnit(AcademicUnit unit) {
        unitDao.delete(unit);
    }

    @Override
    public AcademicUnit findUnitByName(String name) {
        return unitDao.findAcademicUnitByName(name);
    }

    public Optional<AcademicUnit> findUnitById(UUID id) {
        return unitDao.findById(id);
    }
}
