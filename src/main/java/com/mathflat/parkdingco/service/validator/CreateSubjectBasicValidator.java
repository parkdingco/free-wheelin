package com.mathflat.parkdingco.service.validator;

import com.mathflat.parkdingco.domain.Subject;
import com.mathflat.parkdingco.dto.request.CreateSubjectRequest;
import com.mathflat.parkdingco.exception.AlreadySubjectException;
import com.mathflat.parkdingco.repository.SubjectRepository;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;

@Component
public class CreateSubjectBasicValidator implements CreateSubjectValidator {
    private final SubjectRepository subjectRepository;

    public CreateSubjectBasicValidator(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    public boolean validate(CreateSubjectRequest request) {
        if (Objects.isNull(request.getSubject())) {
            throw new IllegalArgumentException("유효하지 않은 리퀘스트입니다.");
        }

        Optional<Subject> optionalSubject = subjectRepository.findByName(request.getSubject().getName());
        if (optionalSubject.isPresent()) {
            throw new AlreadySubjectException(String.format("이미 존재하는 과목입니다. [%s]", optionalSubject.get().getName()));
        }

        return true;
    }
}
