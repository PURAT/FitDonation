package com.company.fitdonation.mapper;

import com.company.fitdonation.dto.FitnessActivityDto;
import com.company.fitdonation.dto.FitnessActivitySummaryDto;
import com.company.fitdonation.entity.FitnessActivity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FitnessActivityMapper {

    FitnessActivity toEntity(FitnessActivityDto dto);

    FitnessActivityDto toDto(FitnessActivity entity);

    default FitnessActivitySummaryDto toDto(List<FitnessActivity> activities) {
        FitnessActivitySummaryDto summaryDto = new FitnessActivitySummaryDto();
        activities.forEach(it -> summaryDto
                .setCalories(summaryDto.getCalories() + it.getCalories())
                .setSteps(summaryDto.getSteps() + it.getSteps())
                .setHeartRate(summaryDto.getHeartRate() + it.getHeartRate()));
        summaryDto.setHeartRate(summaryDto.getHeartRate() / activities.size()); // Считаем среднее значение пульса
        return summaryDto;
    }
}
