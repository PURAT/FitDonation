package com.company.fitdonation.service;

import com.company.fitdonation.dto.AuthRequest;
import com.company.fitdonation.dto.RegistrationRequest;
import com.company.fitdonation.dto.UserDto;
import com.company.fitdonation.dto.UserSummaryDto;
import com.company.fitdonation.entity.Gender;
import com.company.fitdonation.entity.Role;
import com.company.fitdonation.entity.User;
import com.company.fitdonation.exception.AuthException;
import com.company.fitdonation.exception.NoSuchDataException;
import com.company.fitdonation.mapper.UserMapper;
import com.company.fitdonation.repository.UserRepository;
import com.company.fitdonation.security.jwt.JwtProvider;
import com.company.fitdonation.security.service.UserDetailsImpl;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper mapper;
    private final JwtProvider jwtProvider;
    private final PasswordEncoder passwordEncoder;
    private final FitnessActivityService fitnessService;

    public void update(UserDto user) {
        userRepository.save(mapper.toEntity(user));
    }

    public String register(RegistrationRequest request) {
        User user = new User()
                .setFirstname(request.getFirstname())
                .setLastname(request.getLastname())
                .setEmail(request.getEmail())
                .setPassword(passwordEncoder.encode(request.getPassword()))
                .setGender(Gender.fromString(request.getGender()))
                .setPost(request.getPost())
                .setTeam(request.getTeam())
                .setRole(Role.USER);
        userRepository.save(user);
        return jwtProvider.generateToken(user.getEmail());
    }

    public String authenticate(AuthRequest request) {
        User user = userRepository.findByEmail(request.getEmail());
        if (user != null) {
            if (passwordEncoder.matches(request.getPassword(), user.getPassword())) {
                return jwtProvider.generateToken(user.getEmail());
            }
        }
        throw new AuthException("The email or password is incorrect.");
    }

    public List<UserDto> getUsers() {
        return userRepository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    public UserSummaryDto getCurrentUser() {
        String email = ((UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getDetails()).getUsername();
        User currentUser = userRepository.findByEmail(email);
        return mapper.toSummaryDto(mapper.toDto(currentUser), fitnessService.getLastUserActivity(currentUser.getId()));
    }

    public User getByEmail(String email) {
        return userRepository.findByEmail(email);
    }

}
