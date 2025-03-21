package com.co.service.impl;

import com.co.dto.request.LoginRequest;
import com.co.dto.request.RegisterRequest;
import com.co.model.Auth;
import com.co.repository.AuthRepository;
import com.co.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthRepository authRepository;

    @Override
    public Auth register(RegisterRequest request) {
        if (!request.getPassword().equals(request.getRePassword())) {
            throw new RuntimeException("Password not matches");
        }

        Auth auth = Auth.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(request.getPassword())
                .build();

        return authRepository.save(auth);
    }

    @Override
    public Boolean login(LoginRequest request) {
        return authRepository.existsByUsernameAndPassword(request.getUsername(), request.getPassword());
    }
}
