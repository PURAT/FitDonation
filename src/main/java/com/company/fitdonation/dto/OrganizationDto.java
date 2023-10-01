package com.company.fitdonation.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import java.util.UUID;

@Data
@NoArgsConstructor
public class OrganizationDto {

    private UUID id;
    private String name;
    private String email;
    private String avatarPath;
    private String description;
    private String direction;
    private String INN;
    private String KPP;
    private String OGRN;
    private String phoneContacts;
    private String legalAddress;
    private String website;
    private boolean isActive;

}
