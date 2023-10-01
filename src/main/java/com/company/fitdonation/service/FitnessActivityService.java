package com.company.fitdonation.service;

import com.company.fitdonation.dto.FitnessActivitySummaryDto;
import com.company.fitdonation.entity.FitnessActivity;
import com.company.fitdonation.entity.PeriodTime;
import com.company.fitdonation.mapper.FitnessActivityMapper;
import com.company.fitdonation.repository.FitnessActivityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class FitnessActivityService {

    private final FitnessActivityRepository fitnessRepository;
    private final FitnessActivityMapper fitnessMapper;

    public FitnessActivitySummaryDto getUserSummaryActivityByPeriod(UUID userId, PeriodTime period) {
        Instant startOfPeriod = PeriodTime.getStartOfDatePeriod(period);
        List<FitnessActivity> fitnessActivities = fitnessRepository.findByUserIdAndDateAfter(userId, startOfPeriod);
        return fitnessMapper.toDto(fitnessActivities);
    }

    public FitnessActivitySummaryDto getLastUserActivity(UUID userId) {
        return fitnessMapper.toDto(List.of(fitnessRepository.findByUserId(userId)));
    }

}
