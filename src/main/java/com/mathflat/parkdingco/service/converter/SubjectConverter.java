package com.mathflat.parkdingco.service.converter;

import com.mathflat.parkdingco.domain.Subject;
import com.mathflat.parkdingco.dto.response.SubjectResponse;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class SubjectConverter {
    public List<SubjectResponse> convert(List<Subject> subjects) {
        if (Objects.isNull(subjects) || subjects.isEmpty()) {
            return Collections.emptyList();
        }

        return subjects.stream()
                .map(subject -> SubjectResponse.builder()
                        .id(subject.getSubjectId())
                        .name(subject.getName())
                        .build()
                ).collect(Collectors.toList());
    }
}
