package com.fts.funder.controllers;

import com.fts.funder.model.Idea;
import com.fts.funder.service.IdeaServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class IdeaController {

    private final IdeaServices ideaServices;

    public IdeaController(IdeaServices ideaServices) {
        this.ideaServices = ideaServices;
    }

    @GetMapping("/ideas")
    public ResponseEntity<List<Idea>> getIdeas(){
        return ResponseEntity.ok(ideaServices.getAllIdeas());
    }

    @PostMapping("/idea/{user_id}")
    public ResponseEntity<Idea> setIdea(@PathVariable int user_id, @RequestBody Idea request){
        Idea idea = ideaServices.AddIdea(user_id,request);
        return ResponseEntity.status(HttpStatus.CREATED).body(idea);
    }
}
