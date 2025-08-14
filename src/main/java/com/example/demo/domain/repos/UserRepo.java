package com.example.demo.domain.repos;

import com.example.demo.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {
}
