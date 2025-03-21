package com.co.service;


import com.co.dto.request.LoginRequest;
import com.co.dto.request.RegisterRequest;
import com.co.model.Auth;

public interface AuthService {
    Auth register(RegisterRequest request);

    Boolean login(LoginRequest request);
}
