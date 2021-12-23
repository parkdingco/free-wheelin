package com.mathflat.parkdingco.controller;

import com.mathflat.parkdingco.common.ResultResponse;
import com.mathflat.parkdingco.dto.request.CreateStudentRequest;
import com.mathflat.parkdingco.service.CreateStudentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class StudentController {
    private final CreateStudentService createStudentService;

    public StudentController(CreateStudentService createStudentService) {
        this.createStudentService = createStudentService;
    }

    @PostMapping(value = "/students")
    @ResponseStatus(HttpStatus.CREATED)
    public ResultResponse<Void> createStudent(@Valid @RequestBody CreateStudentRequest request) {
        createStudentService.create(request);
        return ResultResponse.success();
    }

}
