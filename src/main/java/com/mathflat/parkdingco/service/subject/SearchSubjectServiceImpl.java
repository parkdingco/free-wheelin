package com.mathflat.parkdingco.service.subject;

import com.mathflat.parkdingco.domain.Subject;
import com.mathflat.parkdingco.dto.response.SearchSubjectResponse;
import com.mathflat.parkdingco.repository.SubjectRepository;
import com.mathflat.parkdingco.service.converter.SubjectConverter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SearchSubjectServiceImpl implements SearchSubjectService {
    private final SubjectRepository subjectRepository;
    private final SubjectConverter subjectConverter;

    public SearchSubjectServiceImpl(SubjectRepository subjectRepository, SubjectConverter subjectConverter) {
        this.subjectRepository = subjectRepository;
        this.subjectConverter = subjectConverter;
    }

    @Override
    @Transactional(readOnly = true)
    public SearchSubjectResponse getSubjects() {
        List<Subject> subjects = subjectRepository.findAll();
        return SearchSubjectResponse.builder().subjects(subjectConverter.convert(subjects)).build();
    }
}
