package com.fts.funder.controllers;

import com.fts.funder.model.Vote;
import com.fts.funder.repository.UserRepository;
import com.fts.funder.service.VoteServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class VoteController {

    private final VoteServices voteServices;

    public VoteController(VoteServices voteServices) {
        this.voteServices = voteServices;
    }

    @PostMapping("/vote/{user_id}/{idea_id}")
    public ResponseEntity<String> postVote(@PathVariable int user_id,@PathVariable int idea_id, @RequestBody Vote request){
        return ResponseEntity.ok(voteServices.addVote(user_id,idea_id,request));
    }
}
