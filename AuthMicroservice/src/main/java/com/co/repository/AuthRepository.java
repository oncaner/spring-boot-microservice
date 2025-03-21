package com.co.repository;

import com.co.model.Auth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthRepository extends JpaRepository<Auth, Long> {

    Boolean existsByUsernameAndPassword(String username, String password);

}
