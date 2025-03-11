package com.fts.funder.controllers;

import com.fts.funder.model.AuthenticationResponse;
import com.fts.funder.model.Dto.LoginDto;
import com.fts.funder.model.User;
import com.fts.funder.repository.UserRepository;
import com.fts.funder.service.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
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
