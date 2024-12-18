package org.example.bt4.service;

import org.example.bt4.entity.User;

import com.example.annotations.AService;

@AService
public class UserService {
    public UserService() {}

    public String getUserName() {
        return User.name;
    }
}
