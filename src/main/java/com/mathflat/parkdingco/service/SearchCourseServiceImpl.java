package com.mathflat.parkdingco.service;

import com.mathflat.parkdingco.domain.Course;
import com.mathflat.parkdingco.dto.response.SearchStudentAverageScoreResponse;
import com.mathflat.parkdingco.dto.response.SearchSubjectAverageScoreResponse;
import com.mathflat.parkdingco.repository.CourseRepository;
import com.mathflat.parkdingco.service.converter.CourseConverter;
import com.mathflat.parkdingco.service.validator.StudentBasicValidator;
import com.mathflat.parkdingco.service.validator.SubjectBasicValidator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class SearchCourseServiceImpl implements SearchCourseService {
    private final StudentBasicValidator studentBasicValidator;
    private final SubjectBasicValidator subjectBasicValidator;
    private final CourseRepository courseRepository;
    private final CourseConverter courseConverter;
    private static final int DEFAULT_AVERAGE_SCORE = -1;

    public SearchCourseServiceImpl(StudentBasicValidator studentBasicValidator,
                                   SubjectBasicValidator subjectBasicValidator,
                                   CourseRepository courseRepository,
                                   CourseConverter courseConverter) {
        this.studentBasicValidator = studentBasicValidator;
        this.subjectBasicValidator = subjectBasicValidator;
        this.courseRepository = courseRepository;
        this.courseConverter = courseConverter;
    }

    @Override
    public SearchStudentAverageScoreResponse getStudentAverageScore(Long studentId) {
        studentBasicValidator.validate(studentId);

        List<Course> courses = courseRepository.findAllByStudentId(studentId);
        return SearchStudentAverageScoreResponse.builder()
                .averageScore(getAverageScore(courses))
                .subjects(courseConverter.convertBySubject(courses))
                .build();
    }

    @Override
    public SearchSubjectAverageScoreResponse getSubjectAverageScore(Long subjectId) {
        subjectBasicValidator.validate(subjectId);
        List<Course> courses = courseRepository.findAllBySubjectIdAndScoreNotNull(subjectId);
        return SearchSubjectAverageScoreResponse.builder()
                .averageScore(getAverageScore(courses))
                .students(courseConverter.convertByStudent(courses))
                .build();
    }

    private int getAverageScore(List<Course> courses) {
        if (courses.stream()
                .noneMatch(course -> Objects.nonNull(course.getScore()))) {
            return DEFAULT_AVERAGE_SCORE;
        }

        List<Course> validCourses = courses.stream()
                .filter(course -> Objects.nonNull(course.getScore()))
                .collect(Collectors.toList());

        int size = validCourses.size();
        int sumScore = validCourses.stream()
                .mapToInt(Course::getScore)
                .sum();

        return sumScore / size;
    }
}
