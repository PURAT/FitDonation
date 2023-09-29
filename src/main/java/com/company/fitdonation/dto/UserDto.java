package com.company.fitdonation.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class UserDto {
    private UUID id;
    private String firstname;
    private String lastname;
    private String password;
    private String email;
    private String team;
    private String post;
    private String role;
}
