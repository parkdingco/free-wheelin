package com.mathflat.parkdingco.dto.response;

import com.mathflat.parkdingco.domain.enums.SchoolType;
import lombok.Builder;
import lombok.Getter;

@Getter
public class StudentResponse {
    private final Long id;

    private final String name;

    private final int age;

    private final SchoolType schoolType;

    private final String phoneNumber;

    @Builder
    public StudentResponse(Long id, String name, int age, SchoolType schoolType, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.schoolType = schoolType;
        this.phoneNumber = phoneNumber;
    }
}
