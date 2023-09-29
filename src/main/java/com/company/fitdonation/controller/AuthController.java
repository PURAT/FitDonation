package com.company.fitdonation.controller;

import com.company.fitdonation.dto.AuthRequest;
import com.company.fitdonation.dto.MessageResponse;
import com.company.fitdonation.dto.RegistrationRequest;
import com.company.fitdonation.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<?> register(@RequestBody @Valid RegistrationRequest request) {
        //todo
        return ResponseEntity.ok().build();
    }

    @PostMapping("/signin")
    public ResponseEntity<?> authenticate(@RequestBody @Valid AuthRequest request) {
        //todo
        return ResponseEntity.ok().build();
    }
}
