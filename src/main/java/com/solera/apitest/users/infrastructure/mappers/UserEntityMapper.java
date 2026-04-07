package com.solera.apitest.users.infrastructure.mappers;

import com.solera.apitest.users.domain.models.User;
import com.solera.apitest.users.infrastructure.entities.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserEntityMapper {

    UserEntity toEntity(User user);

    User toDomain(UserEntity entity);

}
