package com.solera.apitest.users.infrastructure.adapters;

import com.solera.apitest.users.domain.models.User;
import com.solera.apitest.users.domain.repositories.UserRepository;
import com.solera.apitest.users.infrastructure.mappers.UserEntityMapper;
import com.solera.apitest.users.infrastructure.repositories.JpaUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PostgresUserAdapter implements UserRepository {
    private final JpaUserRepository jpaUserRepository;
    private final UserEntityMapper userEntityMapper;

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public Optional<User> findById(Long id) {
        return jpaUserRepository.findById(id).map(userEntityMapper::toDomain);
    }

    @Override
    public List<User> findAll() {
        return jpaUserRepository.findAll().stream().map(userEntityMapper::toDomain).toList();
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public boolean existsById(Long id) {
        return false;
    }

    @Override
    public boolean existsByName(String name) {
        return false;
    }
}
