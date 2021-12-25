package com.mathflat.parkdingco.service.subject;

import com.mathflat.parkdingco.domain.Subject;
import com.mathflat.parkdingco.dto.request.CreateSubjectRequest;

public interface CreateSubjectService {
    Subject create(CreateSubjectRequest request);
}
