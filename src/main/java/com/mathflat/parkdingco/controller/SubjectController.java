package com.mathflat.parkdingco.controller;

import com.mathflat.parkdingco.common.ResultResponse;
import com.mathflat.parkdingco.dto.request.CreateSubjectRequest;
import com.mathflat.parkdingco.dto.response.SearchSubjectResponse;
import com.mathflat.parkdingco.service.CreateSubjectService;
import com.mathflat.parkdingco.service.RemoveSubjectService;
import com.mathflat.parkdingco.service.SearchSubjectService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class SubjectController {
    private final CreateSubjectService createSubjectService;
    private final SearchSubjectService searchSubjectService;
    private final RemoveSubjectService removeSubjectService;

    public SubjectController(CreateSubjectService createSubjectService, SearchSubjectService searchSubjectService, RemoveSubjectService removeSubjectService) {
        this.createSubjectService = createSubjectService;
        this.searchSubjectService = searchSubjectService;
        this.removeSubjectService = removeSubjectService;
    }

    @PostMapping("/subjects")
    @ResponseStatus(HttpStatus.CREATED)
    public ResultResponse<Void> createSubject(@Valid @RequestBody CreateSubjectRequest request) {
        createSubjectService.create(request);
        return ResultResponse.success();
    }

    @GetMapping("/subjects")
    public ResultResponse<SearchSubjectResponse> getSubjects() {
        return ResultResponse.success(searchSubjectService.getSubjects());
    }

    @DeleteMapping("/subjects/{subjectId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeSubject(@PathVariable(value = "subjectId") Long subjectId){
        removeSubjectService.remove(subjectId);
    }
}
