package com.mathflat.parkdingco.dto.request;

import lombok.Getter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.beans.ConstructorProperties;

@Getter
public class CreateStudentRequest {
    @NotNull
    @Valid
    private final StudentRequest student;

    @ConstructorProperties("student")
    public CreateStudentRequest(StudentRequest student) {
        this.student = student;
    }
}
