package com.mathflat.parkdingco.repository;

import com.mathflat.parkdingco.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {
    void deleteByStudentId(Long studentId);

    void deleteBySubjectId(Long subjectId);

    List<Course> findAllByStudentId(Long studentId);

    List<Course> findAllBySubjectId(Long subjectId);

    List<Course> findAllBySubjectIdAndScoreNotNull(Long subjectId);

    Optional<Course> findFirstByStudentIdAndSubjectId(Long studentId, Long subjectId);
}
