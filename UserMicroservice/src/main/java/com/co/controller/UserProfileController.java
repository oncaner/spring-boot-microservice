package com.co.controller;

import com.co.document.UserProfile;
import com.co.dto.request.CreateUserRequest;
import com.co.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.co.config.RestApis.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(USER_PROFILE)
public class UserProfileController {

    private final UserProfileService userProfileService;

    @PostMapping(CREATE_USER)
    public ResponseEntity<Boolean> createUser(@RequestBody CreateUserRequest request) {

        userProfileService.createUser(request);

        return ResponseEntity.ok(Boolean.TRUE);
    }

    @GetMapping(GET_ALL_USERS)
    public ResponseEntity<List<UserProfile>> getAllUsers() {

        return ResponseEntity.ok(userProfileService.getAllUsers());
    }

    @GetMapping("/upper-name")
    public ResponseEntity<String> upperName(@RequestParam String name){

        return ResponseEntity.ok(userProfileService.upperName(name));
    }

}
