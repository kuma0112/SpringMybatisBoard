package com.mycom.springmybatisboard.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// 페이지 이동만 전담
@Controller
public class PageController {
    @GetMapping("/pages/user")
    private String register() {
        return "/user";
    }

    @GetMapping("/pages/login")
    private String login() {
        return "/login";
    }

    @GetMapping("/pages/board")
    private String board() {
        return "/board";
    }
}
