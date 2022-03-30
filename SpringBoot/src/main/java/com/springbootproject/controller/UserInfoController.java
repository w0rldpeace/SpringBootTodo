package com.springbootproject.controller;

import com.springbootproject.entities.User;
import com.springbootproject.security.AuthenticatedUser;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userinfo")
public class UserInfoController {

    @GetMapping
    public AuthenticatedUser getUserInfo(@AuthenticationPrincipal AuthenticatedUser user){
        return user;
    }
}
