package com.example.demo.web.models;

import lombok.Data;

@Data
public class UserCreateResponse {

    private Long id;
    private String username;
    private String email;
    private String firstName;
    private String lastName;

}
