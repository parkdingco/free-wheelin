package com.mathflat.parkdingco.domain;

import com.mathflat.parkdingco.domain.enums.SchoolType;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    private String name;

    private int age;

    @Enumerated(EnumType.STRING)
    private SchoolType schoolType;

    private String phoneNumber;

    @Builder
    public Student(String name, int age, SchoolType schoolType, String phoneNumber) {
        this.name = name;
        this.age = age;
        this.schoolType = schoolType;
        this.phoneNumber = phoneNumber;
    }
}
