package com.solera.apitest.users.application;

import com.solera.apitest.users.domain.models.User;
import com.solera.apitest.users.domain.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllUsersUseCase {

    private final UserRepository userRepository;

    public List<User> execute(){
        return userRepository.findAll();
    }


}
