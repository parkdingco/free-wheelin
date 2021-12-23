package com.mathflat.parkdingco.repository;

import com.mathflat.parkdingco.domain.Score;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepository extends JpaRepository<Score, Long> {
    void deleteByStudentId(Long studentId);
}
