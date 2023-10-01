package com.company.fitdonation.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class FitnessActivitySummaryDto {
    private int steps;
    private int heartRate;
    private int calories;
}
