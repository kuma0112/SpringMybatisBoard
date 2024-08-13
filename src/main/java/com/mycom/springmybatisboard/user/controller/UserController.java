package com.mycom.springmybatisboard.user.controller;

import com.mycom.springmybatisboard.user.dto.UserDto;
import com.mycom.springmybatisboard.user.dto.UserResultDto;
import com.mycom.springmybatisboard.user.service.UserService;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    // UserService DI
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value="/register")
    public UserResultDto register(UserDto userDto) {
        return userService.registerUser(userDto);
    }
}

