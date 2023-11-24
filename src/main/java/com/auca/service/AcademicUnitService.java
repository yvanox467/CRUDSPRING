package com.auca.service;

import com.auca.model.AcademicUnit;

import java.util.List;

public interface AcademicUnitService {
    AcademicUnit insertUnit(AcademicUnit unit);
    List<AcademicUnit> unitList();
    void deleteUnit(AcademicUnit unit);
    AcademicUnit findUnitByName(String name);
}
