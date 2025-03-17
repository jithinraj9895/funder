package com.fts.funder.service;

import com.fts.funder.model.Idea;
import com.fts.funder.model.User;
import com.fts.funder.repository.IdeaRepository;
import com.fts.funder.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IdeaServices {
    public final IdeaRepository ideaRepository;
    public final UserRepository userRepository;


    public IdeaServices(IdeaRepository ideaRepository,UserRepository userRepository) {
        this.ideaRepository = ideaRepository;
        this.userRepository = userRepository;
    }

    public Idea AddIdea(int userId,Idea idea){
        Optional<User> user = userRepository.findById(userId);
        if(user.isPresent()){
            idea.setUser(user.get());
        }else{
            throw new RuntimeException("User not found !!");
        }
        return ideaRepository.save(idea);
    }

    public List<Idea> getAllIdeas(){
        return ideaRepository.findAllByOrderByIdAsc();
    }
}
