package com.company.fitdonation.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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

}
