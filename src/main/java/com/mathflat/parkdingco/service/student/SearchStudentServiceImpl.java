package com.mathflat.parkdingco.service.student;

import com.mathflat.parkdingco.domain.Student;
import com.mathflat.parkdingco.dto.response.SearchStudentResponse;
import com.mathflat.parkdingco.repository.StudentRepository;
import com.mathflat.parkdingco.service.converter.StudentConverter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SearchStudentServiceImpl implements SearchStudentService {
    private final StudentRepository studentRepository;
    private final StudentConverter studentConverter;

    public SearchStudentServiceImpl(StudentRepository studentRepository, StudentConverter studentConverter) {
        this.studentRepository = studentRepository;
        this.studentConverter = studentConverter;
    }

    @Override
    @Transactional(readOnly = true)
    public SearchStudentResponse getStudents() {
        List<Student> students = studentRepository.findAll();
        return SearchStudentResponse.builder().students(studentConverter.convert(students)).build();
    }
}
