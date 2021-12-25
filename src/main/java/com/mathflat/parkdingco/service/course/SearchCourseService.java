package com.mathflat.parkdingco.service.course;

import com.mathflat.parkdingco.dto.response.SearchStudentAverageScoreResponse;
import com.mathflat.parkdingco.dto.response.SearchSubjectAverageScoreResponse;

public interface SearchCourseService {
    SearchStudentAverageScoreResponse getStudentAverageScore(Long studentId);
    SearchSubjectAverageScoreResponse getSubjectAverageScore(Long studentId);
}
