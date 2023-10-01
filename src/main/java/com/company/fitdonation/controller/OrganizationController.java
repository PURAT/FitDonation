package com.company.fitdonation.controller;

import com.company.fitdonation.dto.OrganizationDto;
import com.company.fitdonation.dto.UserDto;
import com.company.fitdonation.service.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/organizations")
@RequiredArgsConstructor
public class OrganizationController {

    private final OrganizationService organizationService;

    @GetMapping
    public ResponseEntity<List<OrganizationDto>> getAllUsers() {
        return ResponseEntity.ok(organizationService.getAllOrganizations());
    }

}
