package com.mathflat.parkdingco.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class SearchStudentResponse {
    private final List<StudentResponse> students;

    @Builder
    public SearchStudentResponse(List<StudentResponse> students) {
        this.students = students;
    }
}
