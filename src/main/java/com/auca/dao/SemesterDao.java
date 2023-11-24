package com.auca.dao;

import com.auca.model.Semester;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SemesterDao extends JpaRepository<Semester, UUID> {
    Semester findSemesterByName(String name);
}
