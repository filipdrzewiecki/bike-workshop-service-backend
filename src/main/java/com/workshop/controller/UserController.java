package com.workshop.controller;

import com.workshop.config.security.dto.RegisterForm;
import com.workshop.config.security.entity.ServiceUser;
import com.workshop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ServiceUser getAuthentication(@RequestBody @Validated RegisterForm registerForm) {
        return userService.createNewUser(registerForm);
    }

    @GetMapping("/{userName}")
    public ServiceUser getAuthentication(@PathVariable String userName) {
        return userService.getUserByUserName(userName);
    }
}
