package com.fts.funder.controllers;

import com.fts.funder.model.AuthenticationResponse;
import com.fts.funder.model.Dto.LoginDto;
import com.fts.funder.model.User;
import com.fts.funder.repository.UserRepository;
import com.fts.funder.service.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthController {

    private final AuthenticationService authenticationService;

    public AuthController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody User user){
        return ResponseEntity.ok(authenticationService.register(user));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody LoginDto user){
        return ResponseEntity.ok(authenticationService.authenticate(user));
    }

}
