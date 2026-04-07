package com.solera.apitest.auth.infrastructure;

import com.solera.apitest.auth.domain.repositories.TokenRepository;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.security.Key;

@Repository
public class JwtTokenAdapter implements TokenRepository {

    private final Key key;
    private final long expiration;

    public JwtTokenAdapter(
            @Value("${spring.security.jwt.secret}") String secret,
            @Value("${spring.security.jwt.expiration}") long expiration
    ) {
        this.key = Keys.hmacShaKeyFor(secret.getBytes());
        this.expiration = expiration;
    }


    @Override
    public String generateToken(String username) {
        return "";
    }

    @Override
    public boolean validateToken(String token) {
        return false;
    }

    @Override
    public String getUsernameFromToken(String token) {
        return "";
    }
}
