package com.solera.apitest.users.infrastructure.repositories;

import com.solera.apitest.users.infrastructure.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaUserRepository extends JpaRepository<UserEntity, Long> {
}
