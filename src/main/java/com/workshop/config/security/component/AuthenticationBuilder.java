package com.workshop.config.security.component;

import com.workshop.config.security.entity.Profile;
import com.workshop.config.security.entity.Role;
import com.workshop.config.security.enums.Roles;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AuthenticationBuilder {

    private final HttpRequestComponent httpRequestComponent;

    public UserAuthentication buildAuthentication(Profile profile, String token) {
        final List<Role> roles = profile.getRoles().stream()
                .filter(role -> Roles.contains(role.getRoleName()))
                .collect(Collectors.toList());

        final Set<GrantedAuthority> authorities = roles
                .stream()
                .map(role -> "ROLE_" + role.getRoleName())
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toSet());

        return UserAuthentication.builder()
                .authorities(authorities)
                .token(token)
                .userIP(httpRequestComponent.getClientIpAddress())
                .profile(profile)
                .isAuthenticated(true)
                .userId(profile.getId())
                .userName(profile.getUsername())
                .build();
    }
}