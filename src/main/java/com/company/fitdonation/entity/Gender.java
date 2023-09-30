package com.company.fitdonation.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum Gender {
    WOMAN("woman"),
    MAN("man");

    private final String gender;

    public static Gender fromString(String gender) {
        return Arrays.stream(Gender.values())
                .filter(it -> it.getGender().equals(gender))
                .findFirst()
                .orElseThrow();
    }

}
