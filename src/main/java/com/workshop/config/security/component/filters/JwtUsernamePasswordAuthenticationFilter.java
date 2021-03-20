package com.workshop.config.security.component.filters;

import com.workshop.config.security.component.UserAuthentication;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.server.MethodNotAllowedException;

import javax.servlet.FilterChain;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static com.workshop.config.security.component.JwtTokenConfig.TOKEN_COOKIE_NAME;


@Slf4j
@RequiredArgsConstructor
public class JwtUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private final AuthenticationManager authenticationManager;


    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        if (!request.getMethod().equals(HttpMethod.POST.toString())) {
            throw new MethodNotAllowedException("Authentication method not supported", List.of(HttpMethod.POST));
        }
        final String username = request.getParameter("username");
        final String password = request.getParameter("password");

        final UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
        return authenticationManager.authenticate(token);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                            FilterChain chain, Authentication authentication) throws IOException {
        if (authentication instanceof UserAuthentication) {
            final UserAuthentication userAuthentication = (UserAuthentication) authentication;
            response.addCookie(new Cookie(TOKEN_COOKIE_NAME, userAuthentication.getCredentials().toString()));
            log.info("User {} successfully authenticated via username and password authentication. Token generated and cookie token set",
                    authentication.getName());
        }

        response.sendRedirect(request.getContextPath() + "/admin");
    }
}
