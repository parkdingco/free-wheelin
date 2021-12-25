package com.mathflat.parkdingco.controller;

import com.mathflat.parkdingco.common.ResultResponse;
import com.mathflat.parkdingco.dto.request.CreateStudentRequest;
import com.mathflat.parkdingco.dto.response.SearchStudentResponse;
import com.mathflat.parkdingco.service.student.CreateStudentFacade;
import com.mathflat.parkdingco.service.student.RemoveStudentService;
import com.mathflat.parkdingco.service.student.SearchStudentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class StudentController {
    private final CreateStudentFacade createStudentFacade;
    private final SearchStudentService searchStudentService;
    private final RemoveStudentService removeStudentService;

    public StudentController(CreateStudentFacade createStudentFacade, SearchStudentService searchStudentService, RemoveStudentService removeStudentService) {
        this.createStudentFacade = createStudentFacade;
        this.searchStudentService = searchStudentService;
        this.removeStudentService = removeStudentService;
    }

    @PostMapping(value = "/students")
    @ResponseStatus(HttpStatus.CREATED)
    public ResultResponse<Void> createStudent(@Valid @RequestBody CreateStudentRequest request) {
        createStudentFacade.create(request);
        return ResultResponse.success();
    }

    @GetMapping(value = "/students")
    public ResultResponse<SearchStudentResponse> getStudents() {
        return ResultResponse.success(searchStudentService.getStudents());
    }

    @DeleteMapping(value = "/students/{studentId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeStudent(@PathVariable(value = "studentId") Long studentId) {
        removeStudentService.remove(studentId);
    }
}
