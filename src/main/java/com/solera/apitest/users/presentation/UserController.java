package com.solera.apitest.users.presentation;

import com.solera.apitest.product.domain.models.Product;
import com.solera.apitest.users.application.GetAllUsersUseCase;
import com.solera.apitest.users.domain.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final GetAllUsersUseCase getAllUsersUseCase;

    @GetMapping("")
    ResponseEntity<List<User>> getAllUsers() {

        List<User> users = getAllUsersUseCase.execute();


        return ResponseEntity.ok(users);
    }
}
