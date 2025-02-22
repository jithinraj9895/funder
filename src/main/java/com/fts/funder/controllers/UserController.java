package com.fts.funder.controllers;

import com.fts.funder.model.Idea;
import com.fts.funder.model.User;
import com.fts.funder.repository.IdeaRepository;
import com.fts.funder.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    private final UserRepository userRepository;
    private final IdeaRepository ideaRepository;

    public UserController(UserRepository userRepository, IdeaRepository ideaRepository) {
        this.userRepository = userRepository;
        this.ideaRepository = ideaRepository;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers(){
        return ResponseEntity.ok(userRepository.findAll());
    }

    @GetMapping("/ideas")
    public ResponseEntity<List<Idea>> getIdeas(){
        return ResponseEntity.ok(ideaRepository.findAll());
    }

    @PostMapping("/idea")
    public ResponseEntity<String> setIdea(@RequestBody Idea request){
        Idea idea = new Idea();
        idea.setTitle(request.getTitle());
        idea.setDescription(request.getDescription());
        idea.setApprovals(request.getApprovals());
        idea.setDisapprovals(request.getDisapprovals());
        ideaRepository.save(idea);
        return ResponseEntity.ok("Idea saved.");
    }
}
