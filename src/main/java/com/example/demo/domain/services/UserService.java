package com.example.demo.domain.services;

import com.example.demo.domain.entities.User;
import com.example.demo.domain.exceptions.UserAlreadyExistsException;
import com.example.demo.domain.exceptions.UserNotFoundException;
import com.example.demo.domain.repos.UserRepo;
import com.example.demo.domain.services.mappers.UserMapper;
import com.example.demo.web.models.UserCreateRequest;
import com.example.demo.web.models.UserCreateResponse;
import com.example.demo.web.models.UserUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserMapper userMapper;

    public UserCreateResponse createUser(UserCreateRequest request) {
        Optional<User> userEntity = userRepo.findByEmailOrUsername(request.getEmail(),request.getUsername());
        if (!userEntity.isEmpty()) {
            throw new UserAlreadyExistsException();
        }
        User user = userMapper.mapToEntity(request);
        User savedUser = userRepo.save(user);
        return userMapper.toResponse(savedUser);
    }

    public List<UserCreateResponse> getAllUsers() {
        return userRepo.findAll()
                .stream()
                .map(userMapper::toResponse)
                .toList();
    }

    public UserCreateResponse getUserById(Long id) {
        User user = userRepo.findById(id)
                .orElseThrow(UserNotFoundException::new);
        return userMapper.toResponse(user);
    }

    public UserCreateResponse updateUser(Long id, UserUpdateRequest request) {
        User existingUser = userRepo.findById(id)
                .orElseThrow(UserNotFoundException::new);

        if (request.getUsername() != null) existingUser.setUsername(request.getUsername());
        if (request.getEmail() != null) existingUser.setEmail(request.getEmail());
        if (request.getFirstName() != null) existingUser.setFirstName(request.getFirstName());
        if (request.getLastName() != null) existingUser.setLastName(request.getLastName());

        User savedUser = userRepo.save(existingUser);
        return userMapper.toResponse(savedUser);
    }


    public void deleteUser(Long id) {
        User existingUser = userRepo.findById(id)
                .orElseThrow(UserNotFoundException::new);

        userRepo.delete(existingUser);
    }
}
