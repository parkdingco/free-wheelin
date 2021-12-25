package com.mathflat.parkdingco.service.validator;

import com.mathflat.parkdingco.exception.NotFoundStudentException;
import com.mathflat.parkdingco.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class StudentBasicValidatorImpl implements StudentBasicValidator {
    private final StudentRepository studentRepository;

    public StudentBasicValidatorImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public boolean validate(Long studentId) {
        if (Objects.isNull(studentId)) {
            throw new IllegalArgumentException("유효하지 않은 리퀘스트입니다.");
        }

        if(!studentRepository.findById(studentId).isPresent()){
            throw new NotFoundStudentException(String.format("학생을 찾을 수 없습니다. [%d]", studentId));
        }

        return true;
    }
}
