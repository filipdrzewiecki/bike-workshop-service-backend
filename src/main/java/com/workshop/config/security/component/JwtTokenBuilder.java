package com.workshop.config.security.component;

import com.auth0.jwt.JWT;
import com.workshop.config.security.entity.Profile;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Slf4j
@Component
@RequiredArgsConstructor
public class JwtTokenBuilder {
    private final JwtTokenSettings tokenSettings;
    private final DateTimeFormatter dateTimeFormat = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    public String createToken(Profile profile) {
        final Long expirationTimeMillis = tokenSettings.getExpirationTimeMillis();
        final long expirationTime = System.currentTimeMillis() + expirationTimeMillis;

        log.info("New token was generated for user: {} and will expire at {}",
                profile.getUsername(), LocalDateTime.now().plus(expirationTimeMillis, ChronoUnit.MILLIS).format(dateTimeFormat)
        );

        return JWT.create()
                .withSubject(profile.getUsername())
                .withClaim(JwtTokenConfig.PARTNER_CLAIM_NAME, profile.getUsername())
                .withExpiresAt(new Date(expirationTime))
                .sign(JwtTokenConfig.getJwtSignAlgorithm(tokenSettings.getSecret()));
    }
}
