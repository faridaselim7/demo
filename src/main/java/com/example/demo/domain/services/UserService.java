package com.example.demo.domain.services;

import com.example.demo.domain.entities.User;
import com.example.demo.domain.exceprions.UserAlreadyExistsException;
import com.example.demo.domain.exceprions.domain.ApplicationException;
import com.example.demo.domain.repos.UserRepo;
import com.example.demo.web.models.UserCreateRequest;
import com.example.demo.web.models.UserRes;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public UserRes createUser(UserCreateRequest request) throws ApplicationException {


        Optional<User> userEntity = userRepo.findByEmailOrUsername(request.getEmail(),request.getUsername());
        if (!userEntity.isEmpty()) {
            throw new UserAlreadyExistsException();
        }
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setEmail(request.getEmail());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        UserRes userRes =UserRes.convertToUserRes(user) ;
        return userRes;
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepo.findById(id);
    }

    public Optional<User> updateUser(Long id, UserCreateRequest request) {
        return userRepo.findById(id).map(user -> {
            user.setUsername(request.getUsername());
            user.setPassword(request.getPassword());
            user.setEmail(request.getEmail());
            user.setFirstName(request.getFirstName());
            user.setLastName(request.getLastName());
            return userRepo.save(user);
        });
    }

    public boolean deleteUser(Long id) {
        if (userRepo.existsById(id)) {
            userRepo.deleteById(id);
            return true;
        }
        return false;
    }
}

