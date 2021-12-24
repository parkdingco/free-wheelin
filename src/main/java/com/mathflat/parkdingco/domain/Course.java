package com.mathflat.parkdingco.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;

    private Long studentId;

    private Long subjectId;

    private Long score;

    @Builder
    public Course(Long studentId, Long subjectId, Long score) {
        this.studentId = studentId;
        this.subjectId = subjectId;
        this.score = score;
    }
}
