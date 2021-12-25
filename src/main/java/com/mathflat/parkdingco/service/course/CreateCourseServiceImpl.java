package com.mathflat.parkdingco.service.course;

import com.mathflat.parkdingco.domain.Course;
import com.mathflat.parkdingco.domain.Student;
import com.mathflat.parkdingco.domain.Subject;
import com.mathflat.parkdingco.repository.CourseRepository;
import com.mathflat.parkdingco.repository.StudentRepository;
import com.mathflat.parkdingco.repository.SubjectRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
public class CreateCourseServiceImpl implements CreateCourseService {
    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;
    private final SubjectRepository subjectRepository;

    public CreateCourseServiceImpl(CourseRepository courseRepository, StudentRepository studentRepository, SubjectRepository subjectRepository) {
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
        this.subjectRepository = subjectRepository;
    }

    @Override
    public void createBy(Student newStudent) {
        if (Objects.isNull(newStudent.getStudentId()) && !courseRepository.findAllByStudentId(newStudent.getStudentId()).isEmpty()) {
            throw new IllegalArgumentException("유효하지 않은 리퀘스트입니다.");
        }

        subjectRepository.findAll().forEach(subject -> create(newStudent.getStudentId(), subject.getSubjectId(), null));
    }

    @Override
    public void createBy(Subject newSubject) {
        if (Objects.isNull(newSubject.getSubjectId()) && !courseRepository.findAllBySubjectId(newSubject.getSubjectId()).isEmpty()) {
            throw new IllegalArgumentException("유효하지 않은 리퀘스트입니다.");
        }

        studentRepository.findAll().forEach(student -> create(student.getStudentId(), newSubject.getSubjectId(), null));
    }

    @Override
    @Transactional
    public void create(Long studentId, Long subjectId, Integer score) {
        Course course = Course.builder().studentId(studentId).subjectId(subjectId).score(score).build();
        courseRepository.save(course);
    }
}
