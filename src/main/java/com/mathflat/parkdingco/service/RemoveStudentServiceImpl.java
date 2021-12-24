package com.mathflat.parkdingco.service;

import com.mathflat.parkdingco.repository.ScoreRepository;
import com.mathflat.parkdingco.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
public class RemoveStudentServiceImpl implements RemoveStudentService {
    private final StudentRepository studentRepository;
    private final ScoreRepository scoreRepository;

    public RemoveStudentServiceImpl(StudentRepository studentRepository, ScoreRepository scoreRepository) {
        this.studentRepository = studentRepository;
        this.scoreRepository = scoreRepository;
    }

    @Override
    @Transactional
    public void remove(Long studentId) {
        if (Objects.isNull(studentId)) {
            return;
        }

        scoreRepository.deleteByStudentId(studentId);

        if (studentRepository.findById(studentId).isPresent()) {
            studentRepository.deleteById(studentId);
        }
    }
}
