package com.mathflat.parkdingco.service.student;

import com.mathflat.parkdingco.domain.Student;
import com.mathflat.parkdingco.dto.request.CreateStudentRequest;

public interface CreateStudentService {
    Student create(CreateStudentRequest request);
}
