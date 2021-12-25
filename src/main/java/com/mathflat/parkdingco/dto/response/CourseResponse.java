package com.mathflat.parkdingco.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class CourseResponse {
    private final Long id;
    private final String name;
    private final int score;

    @Builder
    public CourseResponse(Long id, String name, int score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }
}
