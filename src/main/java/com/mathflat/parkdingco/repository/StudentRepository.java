package com.mathflat.parkdingco.repository;

import com.mathflat.parkdingco.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByPhoneNumber(String phoneNumber);
}
