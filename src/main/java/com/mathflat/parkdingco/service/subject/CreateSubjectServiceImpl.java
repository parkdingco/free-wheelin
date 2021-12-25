package com.mathflat.parkdingco.service.subject;

import com.mathflat.parkdingco.domain.Subject;
import com.mathflat.parkdingco.dto.request.CreateSubjectRequest;
import com.mathflat.parkdingco.repository.SubjectRepository;
import com.mathflat.parkdingco.service.validator.CreateSubjectBasicValidator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreateSubjectServiceImpl implements CreateSubjectService {
    private final SubjectRepository subjectRepository;
    private final CreateSubjectBasicValidator createSubjectBasicValidator;

    public CreateSubjectServiceImpl(SubjectRepository subjectRepository, CreateSubjectBasicValidator createSubjectBasicValidator) {
        this.subjectRepository = subjectRepository;
        this.createSubjectBasicValidator = createSubjectBasicValidator;
    }

    @Override
    @Transactional
    public Subject create(CreateSubjectRequest request) {
        createSubjectBasicValidator.validate(request);

        Subject subject = Subject.builder().name(request.getSubject().getName()).build();
        return subjectRepository.save(subject);
    }
}
