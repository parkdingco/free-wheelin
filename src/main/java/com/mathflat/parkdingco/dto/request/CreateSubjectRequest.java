package com.mathflat.parkdingco.dto.request;

import lombok.Getter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.beans.ConstructorProperties;

@Getter
public class CreateSubjectRequest {
    @NotNull
    @Valid
    private final SubjectRequest subject;

    @ConstructorProperties(value = "subject")
    public CreateSubjectRequest(@NotNull @Valid SubjectRequest subject) {
        this.subject = subject;
    }
}
