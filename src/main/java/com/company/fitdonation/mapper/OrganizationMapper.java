package com.company.fitdonation.mapper;

import com.company.fitdonation.dto.OrganizationDto;
import com.company.fitdonation.entity.Organization;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrganizationMapper {

    OrganizationDto toDto(Organization organization);

    Organization toEntity(OrganizationDto organizationDto);
}
