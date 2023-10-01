package com.company.fitdonation.repository;

import com.company.fitdonation.entity.FitnessActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Repository
public interface FitnessActivityRepository extends JpaRepository<FitnessActivity, UUID> {

    FitnessActivity findByUserId(UUID userId);

    List<FitnessActivity> findByUserIdAndDateAfter(UUID userId, Instant date);
}
