package com.mathflat.parkdingco.service.validator;

import com.mathflat.parkdingco.exception.NotFoundSubjectException;
import com.mathflat.parkdingco.repository.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class SubjectBasicValidatorImpl implements SubjectBasicValidator {
    private final SubjectRepository subjectRepository;

    public SubjectBasicValidatorImpl(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    public boolean validate(Long subjectId) {
        if (Objects.isNull(subjectId)) {
            throw new IllegalArgumentException("유효하지 않은 리퀘스트입니다.");
        }

        if (!subjectRepository.findById(subjectId).isPresent()) {
            throw new NotFoundSubjectException(String.format("과목을 찾을 수 없습니다. [%d]", subjectId));
        }

        return true;
    }
}
