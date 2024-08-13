package com.mycom.springmybatisboard.auth.service;

import com.mycom.springmybatisboard.user.dto.UserDto;

import java.util.Optional;

public interface LoginService {
    // controller에서 userEmail, userpassword가 포함된 user dto 객체를 전달받는다.
    // 거기에 있는 email을 이용해서 LoginDao의 login() 호출
    // -> logindao의 login() 결과가 null이면 userEmail 오류.
    // -> logindao의 login() 결과가 userDto 객체라면 userEmail 존재 -> userPassword과 Dto의 Password를 비교
    // loginService를 호출한 controller에서 null check. --> value가 null이 될 수 있는 경우에 적용하는 optional의 적용
    Optional<UserDto> login(UserDto userDto);
}
