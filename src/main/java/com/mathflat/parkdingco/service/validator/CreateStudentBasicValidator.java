package com.mathflat.parkdingco.service.validator;

import com.mathflat.parkdingco.domain.Student;
import com.mathflat.parkdingco.dto.request.CreateStudentRequest;
import com.mathflat.parkdingco.dto.request.StudentRequest;
import com.mathflat.parkdingco.exception.AlreadyStudentException;
import com.mathflat.parkdingco.repository.StudentRepository;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;

@Component
public class CreateStudentBasicValidator implements CreateStudentValidator {
    private final StudentRepository studentRepository;

    public CreateStudentBasicValidator(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public boolean validate(CreateStudentRequest request) {
        if (Objects.isNull(request.getStudent())) {
            throw new IllegalArgumentException("유효하지 않은 리퀘스트입니다.");
        }

        StudentRequest student = request.getStudent();
        Optional<Student> optionalStudent = studentRepository.findByPhoneNumber(student.getPhoneNumber());
        if (optionalStudent.isPresent()) {
            throw new AlreadyStudentException(String.format("이미 존재하는 학생입니다.[%s]", optionalStudent.get().getPhoneNumber()));
        }

        return true;
    }
}
