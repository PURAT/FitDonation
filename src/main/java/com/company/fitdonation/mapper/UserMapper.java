package com.company.fitdonation.mapper;

import com.company.fitdonation.dto.FitnessActivitySummaryDto;
import com.company.fitdonation.dto.UserDto;
import com.company.fitdonation.dto.UserSummaryDto;
import com.company.fitdonation.entity.Gender;
import com.company.fitdonation.entity.Role;
import com.company.fitdonation.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);

    User toEntity(UserDto userDto);

    private Gender mapGender(String gender) {
        return Gender.fromString(gender);
    }

    private String mapGender(Gender gender) {
        return gender.getGender();
    }

    private Role mapRole(String role) {
        return Role.fromString(role);
    }

    private String mapRole(Role role) {
        return role.getRole();
    }

    UserSummaryDto toSummaryDto(UserDto dto);

    default UserSummaryDto toSummaryDto(UserDto user, FitnessActivitySummaryDto fitnessSummary) {
        UserSummaryDto userSummaryDto = toSummaryDto(user);
        userSummaryDto.setFitnessActivity(fitnessSummary);
        return userSummaryDto;
    }
}
