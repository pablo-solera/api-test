package com.solera.apitest.users.application;

import com.solera.apitest.users.domain.models.User;
import com.solera.apitest.users.domain.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateUserUseCase {

    private final UserRepository userRepository;

    public User execute(User user){
        return userRepository.save(user);
    }


}
