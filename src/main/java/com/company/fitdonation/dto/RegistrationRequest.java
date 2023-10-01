package com.company.fitdonation.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.*;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RegistrationRequest {

    @NotBlank
    @Size(min = 3, max = 20)
    private String firstname;

    @NotBlank
    @Size(min = 3, max = 20)
    private String lastname;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(min = 6, max = 20)
    private String password;

    @NotBlank
    private String team;

    @NotBlank
    private String post;

    @NotBlank
    private String gender;

    @Positive
    @Max(value = 500)
    private double weight;

    @Positive
    @Max(value = 400)
    private double height;

    @Min(value = 18)
    @Max(value = 150)
    private int age;
}
