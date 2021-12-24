package com.mathflat.parkdingco.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class SearchSubjectResponse {
    private final List<SubjectResponse> subjects;

    @Builder
    public SearchSubjectResponse(List<SubjectResponse> subjects) {
        this.subjects = subjects;
    }
}
