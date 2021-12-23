package com.mathflat.parkdingco.service;

import com.mathflat.parkdingco.domain.Student;
import com.mathflat.parkdingco.domain.enums.SchoolType;
import com.mathflat.parkdingco.dto.request.CreateStudentRequest;
import com.mathflat.parkdingco.dto.request.StudentRequest;
import com.mathflat.parkdingco.repository.StudentRepository;
import com.mathflat.parkdingco.service.validator.CreateStudentValidator;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CreateStudentServiceImpl implements CreateStudentService {
    private final StudentRepository studentRepository;
    private final CreateStudentValidator createStudentValidator;

    public CreateStudentServiceImpl(StudentRepository studentRepository, CreateStudentValidator createStudentValidator) {
        this.studentRepository = studentRepository;
        this.createStudentValidator = createStudentValidator;
    }

    @Override
    @Transactional
    public void create(CreateStudentRequest request) {
        createStudentValidator.validate(request);

        StudentRequest studentRequest = request.getStudent();

        Student student = Student.builder()
                .name(studentRequest.getName())
                .age(studentRequest.getAge())
                .schoolType(SchoolType.valueOf(studentRequest.getSchoolType()))
                .phoneNumber(studentRequest.getPhoneNumber())
                .build();

        studentRepository.save(student);
    }
}
