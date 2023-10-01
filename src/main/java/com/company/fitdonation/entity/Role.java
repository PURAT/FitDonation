package com.company.fitdonation.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum Role {
    ADMIN("admin"),
    USER("user"),
    ORGANIZATION("organization");

    private final String role;

    public static Role fromString(String role) {
        return Arrays.stream(Role.values())
                .filter(it -> it.getRole().equals(role))
                .findFirst()
                .orElseThrow();
    }
}
