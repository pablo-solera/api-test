package com.solera.apitest.auth.domain.repositories;

public interface TokenRepository {

    String generateToken(String username);

    boolean validateToken(String token);

    String getUsernameFromToken(String token);
}
