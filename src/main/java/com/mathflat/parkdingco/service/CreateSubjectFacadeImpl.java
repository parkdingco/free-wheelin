package com.mathflat.parkdingco.service;

import com.mathflat.parkdingco.domain.Subject;
import com.mathflat.parkdingco.dto.request.CreateSubjectRequest;
import org.springframework.stereotype.Service;

@Service
public class CreateSubjectFacadeImpl implements CreateSubjectFacade {
    private final CreateSubjectService createSubjectService;
    private final CreateCourseService createCourseService;

    public CreateSubjectFacadeImpl(CreateSubjectService createSubjectService, CreateCourseService createCourseService) {
        this.createSubjectService = createSubjectService;
        this.createCourseService = createCourseService;
    }

    @Override
    public void create(CreateSubjectRequest request) {
        Subject subject = createSubjectService.create(request);
        createCourseService.createBy(subject);
    }
}
