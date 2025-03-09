package com.fts.funder.controllers;

import com.fts.funder.model.Idea;
import com.fts.funder.model.User;
import com.fts.funder.repository.IdeaRepository;
import com.fts.funder.repository.UserRepository;
import com.fts.funder.service.IdeaServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers(){
        return ResponseEntity.ok(userRepository.findAll());
    }
}
