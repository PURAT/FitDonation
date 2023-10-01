package com.company.fitdonation.service;

import com.company.fitdonation.dto.OrganizationDto;
import com.company.fitdonation.dto.RegistrationRequest;
import com.company.fitdonation.dto.UserDto;
import com.company.fitdonation.entity.Organization;
import com.company.fitdonation.mapper.OrganizationMapper;
import com.company.fitdonation.repository.OrganizationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrganizationService {

    private final OrganizationRepository organizationRepository;

    private final OrganizationMapper organizationMapper;

    public List<OrganizationDto> getAllOrganizations() {
        return organizationRepository.findAll().stream()
                .map(organizationMapper::toDto)
                .collect(Collectors.toList());
    }

    public void update(OrganizationDto organization) {
        organizationRepository.save(organizationMapper.toEntity(organization));
    }



}
