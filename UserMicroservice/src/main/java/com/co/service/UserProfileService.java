package com.co.service;

import com.co.document.UserProfile;
import com.co.dto.request.CreateUserRequest;

import java.util.List;

public interface UserProfileService {

    void createUser(CreateUserRequest request);

    List<UserProfile> getAllUsers();

    String upperName(String name);
}
