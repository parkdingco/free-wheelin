package com.mathflat.parkdingco.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class SearchSubjectAverageScoreResponse {
    private final int averageScore;
    private final List<CourseResponse> students;

    @Builder
    public SearchSubjectAverageScoreResponse(int averageScore, List<CourseResponse> students) {
        this.averageScore = averageScore;
        this.students = students;
    }
}
