package com.company.fitdonation.mapper;

import com.company.fitdonation.dto.UserDto;
import com.company.fitdonation.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);

    User toEntity(UserDto userDto);
}
