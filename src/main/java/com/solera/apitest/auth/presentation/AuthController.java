package com.solera.apitest.auth.presentation;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    @GetMapping("/login")
    ResponseEntity<String> getCategoryById(@PathVariable("id") Long id) {



        return ResponseEntity.ok("todo ok");
    }
}
