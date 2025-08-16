package com.example.demo.domain.repos;

import com.example.demo.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User,Long> {
    Optional<User> findByEmailOrUsername(String email, String username);
}
