package com.mathflat.parkdingco.service;

import com.mathflat.parkdingco.domain.Student;
import com.mathflat.parkdingco.dto.request.CreateStudentRequest;
import org.springframework.stereotype.Service;

@Service
public class CreateStudentFacadeImpl implements CreateStudentFacade {
    private final CreateStudentService createStudentService;
    private final CreateCourseService createCourseService;

    public CreateStudentFacadeImpl(CreateStudentService createStudentService, CreateCourseService createCourseService) {
        this.createStudentService = createStudentService;
        this.createCourseService = createCourseService;
    }

    @Override
    public void create(CreateStudentRequest request) {
        Student student = createStudentService.create(request);
        createCourseService.createBy(student);
    }
}
