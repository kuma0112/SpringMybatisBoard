package com.mycom.springmybatisboard.auth.controller;

import com.mycom.springmybatisboard.auth.service.LoginService;
import com.mycom.springmybatisboard.user.dto.UserDto;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/auth")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    @ResponseBody
    public Map<String, String> login(UserDto dto, HttpSession session) {
        Map<String, String> map = new HashMap<>();
        Optional<UserDto> optional = loginService.login(dto);

        // #1 isPresent + get()
        if(optional.isPresent()) {
            UserDto userDto = optional.get();
            session.setAttribute("userDto", userDto);

            map.put("result", "success");
            return map;
        }

        map.put("result", "fail");
        return map;

        // #2 ifPresentOrElse
//        optional.ifPresentOrElse(
//                userDto -> {
//                    session.setAttribute("userDto", userDto);
//                    map.put("result", "success");
//                },
//                () -> {
//                    map.put("result", "fail");
//                }
//        );
//        return map;
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "login";
    }
}
