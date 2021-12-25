package com.mathflat.parkdingco.service.converter;

import com.mathflat.parkdingco.domain.Course;
import com.mathflat.parkdingco.domain.Student;
import com.mathflat.parkdingco.domain.Subject;
import com.mathflat.parkdingco.dto.response.CourseResponse;
import com.mathflat.parkdingco.repository.StudentRepository;
import com.mathflat.parkdingco.repository.SubjectRepository;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class CourseConverter {
    private final SubjectRepository subjectRepository;
    private final StudentRepository studentRepository;
    private static final int DEFAULT_SCORE = -1;

    public CourseConverter(SubjectRepository subjectRepository, StudentRepository studentRepository) {
        this.subjectRepository = subjectRepository;
        this.studentRepository = studentRepository;
    }

    public List<CourseResponse> convertBySubject(List<Course> courses) {
        if (Objects.isNull(courses) || courses.isEmpty()) {
            return Collections.emptyList();
        }

        return courses.stream()
                .map(course -> CourseResponse.builder()
                        .id(course.getCourseId())
                        .name(subjectRepository.findById(course.getSubjectId()).map(Subject::getName).orElse(""))
                        .score(Objects.isNull(course.getScore()) ? DEFAULT_SCORE : course.getScore())
                        .build()
                ).collect(Collectors.toList());
    }

    public List<CourseResponse> convertByStudent(List<Course> courses) {
        if (Objects.isNull(courses) || courses.isEmpty()) {
            return Collections.emptyList();
        }

        return courses.stream()
                .map(course -> CourseResponse.builder()
                        .id(course.getCourseId())
                        .name(studentRepository.findById(course.getStudentId()).map(Student::getName).orElse(""))
                        .score(Objects.isNull(course.getScore()) ? DEFAULT_SCORE : course.getScore())
                        .build()
                ).collect(Collectors.toList());
    }
}
