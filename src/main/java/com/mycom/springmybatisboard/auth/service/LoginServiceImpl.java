package com.mycom.springmybatisboard.auth.service;

import com.mycom.springmybatisboard.auth.dao.LoginDao;
import com.mycom.springmybatisboard.user.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class LoginServiceImpl implements LoginService{
    private final LoginDao loginDao;

    public LoginServiceImpl(LoginDao loginDao) {
        this.loginDao = loginDao;
    }

    @Override
    public Optional<UserDto> login(UserDto dto) {
        UserDto userDto = loginDao.login(dto.getUserEmail());
        if (userDto != null && dto.getUserPassword().equals(userDto.getUserPassword())){
            userDto.setUserPassword(null);
            return Optional.of(userDto);
        }
        return Optional.empty();
    }
}
