package com.mycom.springmybatisboard.auth.dao;

import com.mycom.springmybatisboard.user.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginDao {
    UserDto login(String userEmail);

}
