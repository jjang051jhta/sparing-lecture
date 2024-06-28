package com.jjang051.first.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
public class MemberController {

    @GetMapping("/signin")
    public String signinForm() {
        return "member/signin";
    }

    @PostMapping("/signin")
    public String signin(
            @RequestParam String userName,
            @RequestParam String userPw
    ) {
        log.info("userName={},userPw={}",userName,userPw);

        return "redirect:test?username="+userName;
    }
}
