package com.mathflat.parkdingco.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class SubjectResponse {
    private final Long id;

    private final String name;

    @Builder
    public SubjectResponse(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
