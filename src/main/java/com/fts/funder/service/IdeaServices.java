package com.fts.funder.service;

import com.fts.funder.model.Idea;
import com.fts.funder.repository.IdeaRepository;
import org.springframework.stereotype.Service;

@Service
public class IdeaServices {
    public final IdeaRepository ideaRepository;


    public IdeaServices(IdeaRepository ideaRepository) {
        this.ideaRepository = ideaRepository;
    }

    public Idea AddIdea(Idea idea){
        ideaRepository.save(idea);
        return idea;
    }
}
