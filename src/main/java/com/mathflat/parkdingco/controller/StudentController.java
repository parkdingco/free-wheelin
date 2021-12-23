package com.mathflat.parkdingco.controller;

import com.mathflat.parkdingco.common.ResultResponse;
import com.mathflat.parkdingco.dto.request.CreateStudentRequest;
import com.mathflat.parkdingco.dto.response.SearchStudentResponse;
import com.mathflat.parkdingco.service.CreateStudentService;
import com.mathflat.parkdingco.service.SearchStudentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class StudentController {
    private final CreateStudentService createStudentService;
    private final SearchStudentService searchStudentService;

    public StudentController(CreateStudentService createStudentService, SearchStudentService searchStudentService) {
        this.createStudentService = createStudentService;
        this.searchStudentService = searchStudentService;
    }

    @PostMapping(value = "/students")
    @ResponseStatus(HttpStatus.CREATED)
    public ResultResponse<Void> createStudent(@Valid @RequestBody CreateStudentRequest request) {
        createStudentService.create(request);
        return ResultResponse.success();
    }

    @GetMapping(value = "/students")
    public ResultResponse<SearchStudentResponse> getStudents() {
        return ResultResponse.success(searchStudentService.getStudents());
    }
}
