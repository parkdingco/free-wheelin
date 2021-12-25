package com.mathflat.parkdingco.service;

import com.mathflat.parkdingco.domain.Course;
import com.mathflat.parkdingco.exception.NotFoundCourseException;
import com.mathflat.parkdingco.repository.CourseRepository;
import com.mathflat.parkdingco.service.validator.StudentBasicValidator;
import com.mathflat.parkdingco.service.validator.SubjectBasicValidator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ModifyCourseServiceImpl implements ModifyCourseService {
    private final CourseRepository courseRepository;
    private final StudentBasicValidator studentBasicValidator;
    private final SubjectBasicValidator subjectBasicValidator;

    public ModifyCourseServiceImpl(CourseRepository courseRepository, StudentBasicValidator studentBasicValidator, SubjectBasicValidator subjectBasicValidator) {
        this.courseRepository = courseRepository;
        this.studentBasicValidator = studentBasicValidator;
        this.subjectBasicValidator = subjectBasicValidator;
    }

    @Override
    @Transactional
    public void assignment(Long studentId, Long subjectId, int score) {
        studentBasicValidator.validate(studentId);
        subjectBasicValidator.validate(subjectId);

        Course course = courseRepository.findFirstByStudentIdAndSubjectId(studentId, subjectId)
                .orElseThrow(() -> new NotFoundCourseException(String.format("과목을 찾을 수 없습니다. [studentId: %d], [subjectId: %d]", studentId, subjectId)));

        course.assignmentScore(score);
    }
}
