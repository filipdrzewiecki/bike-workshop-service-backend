package com.workshop.config.security.component;

import com.workshop.config.security.entity.ServiceUser;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Builder
public class UserAuthentication implements Authentication {
    private Long userId;
    private String token;
    private boolean isAuthenticated;
    private Collection<? extends GrantedAuthority> authorities;
    private String userName;
    private ServiceUser serviceUser;
    private String userIP;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    @JsonIgnore
    public Object getCredentials() {
        return token;
    }

    @Override
    @JsonIgnore
    public Object getDetails() {
        return serviceUser;
    }

    @Override
    @JsonIgnore
    public Object getPrincipal() {
        return userId;
    }

    @Override
    public boolean isAuthenticated() {
        return isAuthenticated;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
    }

    @Override
    public String getName() {
        return userName;
    }


    public String getUserIP() {
        return userIP;
    }
}
