package com.workshop.config.security.Service;

import com.workshop.config.security.component.JwtTokenBuilder;
import com.workshop.config.security.dto.LoginForm;
import com.workshop.config.security.entity.Role;
import com.workshop.config.security.entity.ServiceUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;
import com.workshop.service.UserService;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserService userService;
    private final JwtTokenBuilder jwtTokenBuilder;

    public Map createToken(LoginForm loginForm) {
        log.info("Generating token for user {}", loginForm.getLogin());
        final ServiceUser serviceUser = userService.findByUserNameAndPlainTextPassword(loginForm.getLogin(), loginForm.getPassword())
                .orElseThrow(() -> new BadCredentialsException("Bad credentials"));

        log.info("Token successfully generated for user {}", loginForm.getLogin());
        String token = jwtTokenBuilder.createToken(serviceUser);
        Set<String> roles = serviceUser.getRoles().stream().map(Role::getRoleName).collect(Collectors.toSet());
        return Map.of("userName", serviceUser.getUsername(), "token", token, "roles", roles);
    }
}