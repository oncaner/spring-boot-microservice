package com.co.controller;

import com.co.dto.request.LoginRequest;
import com.co.dto.request.RegisterRequest;
import com.co.model.Auth;
import com.co.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.co.config.RestApis.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(AUTH_SERVICE)
public class AuthController {

    private final AuthService authService;

    @PostMapping(REGISTER)
    public ResponseEntity<Auth> register(@RequestBody RegisterRequest request) {

        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping(LOGIN)
    public ResponseEntity<Boolean> login(@RequestBody LoginRequest request) {

        return ResponseEntity.ok(authService.login(request));
    }

}
