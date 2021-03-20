package com.workshop.config.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import com.workshop.config.security.component.Http401UnauthorizedEntryPoint;
import com.workshop.config.security.component.JwtAuthenticationProvider;
import com.workshop.config.security.component.filters.JwtAuthorizationFilter;
import com.workshop.config.security.component.JwtTokenSettings;
import com.workshop.config.security.component.filters.JwtUsernamePasswordAuthenticationFilter;

import java.util.Map;

@Configuration
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final JwtTokenSettings jwtTokenSettings;
    private final JwtAuthenticationProvider jwtAuthenticationProvider;
    private final Http401UnauthorizedEntryPoint authEntryPoint;

    //@Value("${security.login.force_https}")
    private boolean loginForceHttps = false;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .cors().and()
                .csrf().disable()
                .addFilter(new JwtUsernamePasswordAuthenticationFilter(authenticationManager()))
                .addFilter(new JwtAuthorizationFilter(authenticationManager(), jwtTokenSettings))
                .authorizeRequests()
                    .mvcMatchers("/authentication/login").permitAll()
                    .mvcMatchers("/user/register").permitAll()
                    .mvcMatchers("/**").permitAll()
                    .mvcMatchers("/bicycles/**").hasAnyRole("ADMIN")
                    .mvcMatchers("/system/health").hasAnyRole("EMPLOYEE")
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .permitAll()
                    .and()
                .logout()
                    .permitAll()
                    .and()
                .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                    .and()
                .exceptionHandling().authenticationEntryPoint(authEntryPoint);

    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring()
                .mvcMatchers("/webjars/springfox-swagger-ui/**")
                .mvcMatchers("/swagger-ui.html/**")
                .mvcMatchers("/swagger-resources/**")
                .mvcMatchers("/css/**");
    }

    private LoginUrlAuthenticationEntryPoint getLoginUrlAuthenticationEntryPoint() {
        final LoginUrlAuthenticationEntryPoint loginUrlAuthenticationEntryPoint = new LoginUrlAuthenticationEntryPoint("/login");
        loginUrlAuthenticationEntryPoint.setForceHttps(loginForceHttps);
        return loginUrlAuthenticationEntryPoint;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(jwtAuthenticationProvider);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new DelegatingPasswordEncoder("bcrypt", Map.of("bcrypt", new BCryptPasswordEncoder()));
    }
}