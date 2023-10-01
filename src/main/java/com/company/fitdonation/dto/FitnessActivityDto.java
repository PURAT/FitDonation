package com.company.fitdonation.dto;

import com.company.fitdonation.entity.TypeActivity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.Instant;
import java.util.UUID;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class FitnessActivityDto {
    private UUID userId;
    private int steps;
    private int heartRate;
    private int calories;
    private Instant date;
    private int duration;
    private TypeActivity type;
}
