package com.mathflat.parkdingco.service.validator;

import com.mathflat.parkdingco.dto.request.CreateSubjectRequest;

public interface CreateSubjectValidator {
    boolean validate(CreateSubjectRequest request);
}
