package com.company.fitdonation.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Role {
    ADMIN("admin"),
    USER("user"),
    ORGANIZATION("organization");

    private final String name;
}
