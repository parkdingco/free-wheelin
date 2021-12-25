package com.mathflat.parkdingco.controller;

import com.mathflat.parkdingco.common.ResultResponse;
import com.mathflat.parkdingco.dto.request.ScoreRequest;
import com.mathflat.parkdingco.dto.response.SearchStudentAverageScoreResponse;
import com.mathflat.parkdingco.dto.response.SearchSubjectAverageScoreResponse;
import com.mathflat.parkdingco.service.course.ModifyCourseService;
import com.mathflat.parkdingco.service.course.RemoveCourseService;
import com.mathflat.parkdingco.service.course.SearchCourseService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class CourseController {
    private final ModifyCourseService modifyCourseService;
    private final RemoveCourseService removeCourseService;
    private final SearchCourseService searchCourseService;

    public CourseController(ModifyCourseService modifyCourseService, RemoveCourseService removeCourseService, SearchCourseService searchCourseService) {
        this.modifyCourseService = modifyCourseService;
        this.removeCourseService = removeCourseService;
        this.searchCourseService = searchCourseService;
    }

    @PostMapping(value = "/students/{studentId}/subjects/{subjectId}/scores")
    @ResponseStatus(HttpStatus.CREATED)
    public ResultResponse<Void> assignmentScore(@PathVariable(value = "studentId") Long studentId,
                                                @PathVariable(value = "subjectId") Long subjectId,
                                                @Valid @RequestBody ScoreRequest request) {
        modifyCourseService.assignment(studentId, subjectId, request.getScore());
        return ResultResponse.success();
    }

    @PutMapping(value = "/students/{studentId}/subjects/{subjectId}/scores")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void modifyScore(@PathVariable(value = "studentId") Long studentId,
                            @PathVariable(value = "subjectId") Long subjectId,
                            @Valid @RequestBody ScoreRequest request) {
        modifyCourseService.assignment(studentId, subjectId, request.getScore());
    }

    @DeleteMapping(value = "/students/{studentId}/subjects/{subjectId}/scores")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeScore(@PathVariable(value = "studentId") Long studentId,
                            @PathVariable(value = "subjectId") Long subjectId) {
        removeCourseService.remove(studentId, subjectId);
    }

    @GetMapping(value = "/students/{studentId}/average-score")
    public ResultResponse<SearchStudentAverageScoreResponse> getStudentAverageScore(@PathVariable(value = "studentId") Long studentId) {
        return ResultResponse.success(searchCourseService.getStudentAverageScore(studentId));
    }

    @GetMapping(value = "/subjects/{subjectId}/average-score")
    public ResultResponse<SearchSubjectAverageScoreResponse> getSubjectAverageScore(@PathVariable(value = "subjectId") Long subjectId) {
        return ResultResponse.success(searchCourseService.getSubjectAverageScore(subjectId));
    }
}
