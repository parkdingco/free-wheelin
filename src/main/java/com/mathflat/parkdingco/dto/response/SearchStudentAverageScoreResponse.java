package com.mathflat.parkdingco.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class SearchStudentAverageScoreResponse {
    private final int averageScore;
    private final List<CourseResponse> subjects;

    @Builder
    public SearchStudentAverageScoreResponse(int averageScore, List<CourseResponse> subjects) {
        this.averageScore = averageScore;
        this.subjects = subjects;
    }
}
