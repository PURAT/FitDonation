package com.company.fitdonation.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.Instant;
import java.util.UUID;

@Accessors(chain = true)
@Entity
@Data
@Table(name = "\"activity\"")
public class FitnessActivity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(name = "user_id")
    private UUID userId;

    @Column(name = "steps")
    private int steps;

    @Column(name = "heart_rate")
    private int heartRate;

    @Column(name = "calories")
    private int calories;

    @Column(name = "date")
    private Instant date;

    @Column(name = "duration")
    private int durationInMinutes;

    @Column(name = "type")
    private TypeActivity type;

}
