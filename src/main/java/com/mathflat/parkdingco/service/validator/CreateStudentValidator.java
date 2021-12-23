package com.mathflat.parkdingco.service.validator;

import com.mathflat.parkdingco.dto.request.CreateStudentRequest;

public interface CreateStudentValidator {
    boolean validate(CreateStudentRequest request);
}
