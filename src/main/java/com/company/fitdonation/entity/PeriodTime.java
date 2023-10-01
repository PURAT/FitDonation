package com.company.fitdonation.entity;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;

public enum PeriodTime {
    DAY,
    WEEK,
    MONTH;

    public static Instant getStartOfDatePeriod(PeriodTime period) {
        LocalDate today = LocalDate.now(ZoneOffset.UTC);
        switch (period) {
            case DAY:
                return today.atStartOfDay(ZoneOffset.UTC).toInstant();
            case WEEK:
                return today.minusWeeks(1).atStartOfDay().toInstant(ZoneOffset.UTC);
            default:
                return today.minusMonths(1).atStartOfDay().toInstant(ZoneOffset.UTC);
        }
    }
}
