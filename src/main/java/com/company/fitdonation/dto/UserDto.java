package com.company.fitdonation.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.UUID;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class UserDto {
    private UUID id;
    private String firstname;
    private String lastname;
    private String password;
    private String email;
    private String team;
    private String post;
    private String role;
    private String gender;
}
