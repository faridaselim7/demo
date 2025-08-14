package com.example.demo.web.models;

import com.example.demo.domain.entities.User;
import jdk.jfr.DataAmount;
import lombok.Data;

@Data
public class UserRes {

    private Long id;
    private String username;
    private String email;
    private String firstName;
    private String lastName;

    public static UserRes convertToUserRes(User user) {
        UserRes userRes = new UserRes();
        userRes.id = user.getId();
        userRes.username = user.getUsername();
        userRes.email = user.getEmail();
        userRes.firstName = user.getFirstName();
        userRes.lastName = user.getLastName();
        return userRes;
    }
}
