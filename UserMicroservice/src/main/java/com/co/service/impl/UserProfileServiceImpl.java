package com.co.service.impl;

import com.co.document.UserProfile;
import com.co.dto.request.CreateUserRequest;
import com.co.repository.UserProfileRepository;
import com.co.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserProfileServiceImpl implements UserProfileService {

    private final UserProfileRepository userProfileRepository;
    private final CacheManager cacheManager;

    @Override
    public void createUser(CreateUserRequest request) {

        UserProfile userProfile = UserProfile.builder()
                .authId(request.getAuthId())
                .username(request.getUsername())
                .email(request.getEmail())
                .build();

        userProfileRepository.save(userProfile);
    }

    @Override
    public List<UserProfile> getAllUsers() {

        return userProfileRepository.findAll();
    }

    @Override
    @Cacheable(cacheNames = "upper-case")
    public String upperName(String name) {
        String result = name.toUpperCase();

        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    public void clearCache(){
        cacheManager.getCache("upper-case").clear();
    }

}
