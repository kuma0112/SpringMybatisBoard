package com.mycom.springmybatisboard.user.dao;

import com.mycom.springmybatisboard.user.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface UserDao {
    int registerUser(UserDto userDto);
}
