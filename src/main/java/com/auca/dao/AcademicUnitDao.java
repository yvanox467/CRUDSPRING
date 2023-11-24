package com.auca.dao;

import com.auca.model.AcademicUnit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AcademicUnitDao extends JpaRepository<AcademicUnit, UUID> {
    AcademicUnit findAcademicUnitByName(String unitName);
}
