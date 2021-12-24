package com.mathflat.parkdingco.service;

import com.mathflat.parkdingco.domain.Student;
import com.mathflat.parkdingco.domain.Subject;

public interface CreateCourseService {
    void createBy(Student newStudent);

    void createBy(Subject newSubject);

    void create(Long studentId, Long subjectId, Long score);
}