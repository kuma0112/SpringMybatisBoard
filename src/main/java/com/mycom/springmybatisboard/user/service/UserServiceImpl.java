package com.mycom.springmybatisboard.user.service;

import com.mycom.springmybatisboard.user.dao.UserDao;
import com.mycom.springmybatisboard.user.dto.UserDto;
import com.mycom.springmybatisboard.user.dto.UserResultDto;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    // UserDao DI
    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserResultDto registerUser(UserDto userDto) {
        UserResultDto userResultDto = new UserResultDto();
        if( userDao.registerUser(userDto) == 1 ) {
            userResultDto.setResult("success");
        }else {
            userResultDto.setResult("fail");
        }
        return userResultDto;
    }
}
