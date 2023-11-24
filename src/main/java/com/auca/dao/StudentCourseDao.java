package com.auca.dao;

import com.auca.model.StudentCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface StudentCourseDao extends JpaRepository<StudentCourse, UUID> {
    @Query("select st from StudentCourse st where st.course.courseDefinition.id=?1 and st.studentRegistration.semester.id=?2")
    List<StudentCourse> findStudentCourseByCourseAndSemester(UUID courseId, UUID semId);

    @Query("select st from StudentCourse st where st.studentRegistration.student.id=?1")
    List<StudentCourse> findStudentCourseByStudent(UUID stId);
}
