package com.mathflat.parkdingco.service.converter;

import com.mathflat.parkdingco.domain.Student;
import com.mathflat.parkdingco.dto.response.StudentResponse;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class StudentConverter {
    public List<StudentResponse> convert(List<Student> students) {
        if (Objects.isNull(students) || students.isEmpty()) {
            return Collections.emptyList();
        }

        return students.stream()
                .map(student -> StudentResponse.builder()
                        .id(student.getStudentId())
                        .age(student.getAge())
                        .phoneNumber(student.getPhoneNumber())
                        .name(student.getName())
                        .build()
                ).collect(Collectors.toList());
    }
}
