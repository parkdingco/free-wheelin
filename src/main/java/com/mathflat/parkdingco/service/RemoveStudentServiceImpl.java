package com.mathflat.parkdingco.service;

import com.mathflat.parkdingco.repository.CourseRepository;
import com.mathflat.parkdingco.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
public class RemoveStudentServiceImpl implements RemoveStudentService {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public RemoveStudentServiceImpl(StudentRepository studentRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    @Transactional
    public void remove(Long studentId) {
        if (Objects.isNull(studentId)) {
            return;
        }

        courseRepository.deleteByStudentId(studentId);

        if (studentRepository.findById(studentId).isPresent()) {
            studentRepository.deleteById(studentId);
        }
    }
}
