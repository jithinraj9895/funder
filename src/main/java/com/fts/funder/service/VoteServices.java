package com.fts.funder.service;

import com.fts.funder.model.User;
import com.fts.funder.model.Vote;
import com.fts.funder.repository.UserRepository;
import com.fts.funder.repository.VoteRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VoteServices {

    private final VoteRepository voteRepository;
    private final UserRepository userRepository;

    public VoteServices(VoteRepository voteRepository, UserRepository userRepository) {
        this.voteRepository = voteRepository;
        this.userRepository = userRepository;
    }


    public Vote addVote(int userId,Vote vote){
        Optional<User> user = userRepository.findById(userId);
        if(user.isPresent()){
            vote.setUser(user.get());
        }else{
            throw new RuntimeException("User not found !!");
        }

        return voteRepository.save(vote);
    }

}
