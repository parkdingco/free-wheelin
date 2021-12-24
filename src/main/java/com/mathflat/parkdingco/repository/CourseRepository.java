package com.mathflat.parkdingco.repository;

import com.mathflat.parkdingco.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
    void deleteByStudentId(Long studentId);
    void deleteBySubjectId(Long subjectId);
}
