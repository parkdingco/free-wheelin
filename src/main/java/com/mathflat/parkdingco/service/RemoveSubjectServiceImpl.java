package com.mathflat.parkdingco.service;

import com.mathflat.parkdingco.repository.CourseRepository;
import com.mathflat.parkdingco.repository.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class RemoveSubjectServiceImpl implements RemoveSubjectService {
    private final SubjectRepository subjectRepository;
    private final CourseRepository courseRepository;

    public RemoveSubjectServiceImpl(SubjectRepository subjectRepository, CourseRepository courseRepository) {
        this.subjectRepository = subjectRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public void remove(Long subjectId) {
        if (Objects.isNull(subjectId)) {
            return;
        }

        courseRepository.deleteBySubjectId(subjectId);

        if (subjectRepository.findById(subjectId).isPresent()) {
            subjectRepository.deleteById(subjectId);
        }
    }
}
