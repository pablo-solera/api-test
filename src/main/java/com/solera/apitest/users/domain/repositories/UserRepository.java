package com.solera.apitest.users.domain.repositories;

import com.solera.apitest.users.domain.models.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    User save(User user);

    Optional<User> findById(Long id);

    List<User> findAll();

    void deleteById(Long id);

    boolean existsById(Long id);

    boolean existsByName(String name);
}
