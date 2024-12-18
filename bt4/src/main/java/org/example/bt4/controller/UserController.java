package org.example.bt4.controller;

import org.example.bt4.service.UserService;

import com.example.annotations.AController;
import com.example.annotations.AGetMapping;
import com.example.annotations.Inject;

@AController(path = "/user")
public class UserController {
    @Inject
    private UserService userService;

    public UserController() {}

    @AGetMapping(path = "/name")
    public String getUserName () {
        return this.userService.getUserName();
    }
}
