package com.company.fitdonation.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.UUID;

@Data
@Accessors(chain = true)
@Entity
@Table(name = "\"organization\"")
public class Organization {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "avatar")
    private String avatarPath;

    @Size(min = 5, message = "Слишком короткое описание")
    @Size(max = 301, message = "Слишком длинное описание")
    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "direction", nullable = false)
    private String direction;

    @Column(name = "INN", nullable = false)
    private String INN;

    @Column(name = "KPP", nullable = false)
    private String KPP;

    @Column(name = "OGRN", nullable = false)
    private String OGRN;

    @Column(name = "phoneContacts", nullable = false)
    private String phoneContacts;

    @Column(name = "legalAddress", nullable = false)
    private String legalAddress;

    @Column(name = "website", nullable = false)
    private String website;

    @Column(name = "isActive", nullable = false)
    private boolean isActive;

}
