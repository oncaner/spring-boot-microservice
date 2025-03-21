package com.co.service.impl;

import com.co.dto.request.CreateUserRequest;
import com.co.dto.request.LoginRequest;
import com.co.dto.request.RegisterRequest;
import com.co.manager.UserProfileManager;
import com.co.model.Auth;
import com.co.repository.AuthRepository;
import com.co.service.AuthService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthRepository authRepository;
    private final UserProfileManager userProfileManager;

    @Override
    @Transactional
    public Auth register(RegisterRequest request) {
        if (!request.getPassword().equals(request.getRePassword())) {
            throw new RuntimeException("Password not matches");
        }

        Auth auth = Auth.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(request.getPassword())
                .build();

        Auth savedAuth = authRepository.save(auth);

        CreateUserRequest createUserRequest = CreateUserRequest.builder()
                .authId(savedAuth.getId())
                .username(auth.getUsername())
                .email(auth.getEmail())
                .build();

        userProfileManager.createUser(createUserRequest);

        return auth;
    }

    @Override
    public Boolean login(LoginRequest request) {
        return authRepository.existsByUsernameAndPassword(request.getUsername(), request.getPassword());
    }
}
