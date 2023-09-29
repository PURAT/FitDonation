package com.company.fitdonation.service;

import com.company.fitdonation.dto.UserDto;
import com.company.fitdonation.entity.User;
import com.company.fitdonation.mapper.UserMapper;
import com.company.fitdonation.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper mapper;

    public void save(UserDto user) {
        userRepository.save(mapper.toEntity(user));
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }


}
