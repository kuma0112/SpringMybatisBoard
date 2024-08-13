package com.mycom.springmybatisboard.user.service;

import com.mycom.springmybatisboard.user.dto.UserDto;
import com.mycom.springmybatisboard.user.dto.UserResultDto;

public interface UserService {
    UserResultDto registerUser(UserDto userDto);
}

