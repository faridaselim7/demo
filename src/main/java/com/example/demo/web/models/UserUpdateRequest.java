package com.example.demo.web.models;

import lombok.Data;

@Data
public class UserUpdateRequest {
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
}
