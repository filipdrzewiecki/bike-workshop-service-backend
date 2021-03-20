package com.workshop.config.security.component;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "security.token")
    public JwtTokenSettings jwtTokenSettings() {
        return new JwtTokenSettings();
    }
}
