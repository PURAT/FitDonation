package com.company.fitdonation.controller;

import com.company.fitdonation.dto.*;
import com.company.fitdonation.entity.Role;
import com.company.fitdonation.entity.User;
import com.company.fitdonation.exception.NoSuchDataException;
import com.company.fitdonation.security.jwt.JwtProvider;
import com.company.fitdonation.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.awt.print.Book;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Tag(name="auth", description="Регистрация/Аутентификация")
public class AuthController {

    private final UserService userService;

    @Operation(
            summary = "Регистрация сотрудника",
            description = "Позволяет зарегистрировать сотрудника"
    )
    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> register(@RequestBody @Valid RegistrationRequest request) {
        return ResponseEntity.ok(new AuthResponse(userService.register(request)));
    }

    @Operation(
            summary = "Аутентификация сотрудника",
            description = "Позволяет войти сотруднику на платформу"
    )
    @PostMapping("/signin")
    public ResponseEntity<AuthResponse> authenticate(@RequestBody @Valid AuthRequest request) {
        return ResponseEntity.ok(new AuthResponse(userService.authenticate(request)));
    }
}
