package com.mathflat.parkdingco.service;

import com.mathflat.parkdingco.repository.ScoreRepository;
import com.mathflat.parkdingco.repository.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class RemoveSubjectServiceImpl implements RemoveSubjectService {
    private final SubjectRepository subjectRepository;
    private final ScoreRepository scoreRepository;

    public RemoveSubjectServiceImpl(SubjectRepository subjectRepository, ScoreRepository scoreRepository) {
        this.subjectRepository = subjectRepository;
        this.scoreRepository = scoreRepository;
    }

    @Override
    public void remove(Long subjectId) {
        if (Objects.isNull(subjectId)) {
            return;
        }

        scoreRepository.deleteBySubjectId(subjectId);

        if (subjectRepository.findById(subjectId).isPresent()) {
            subjectRepository.deleteById(subjectId);
        }
    }
}
