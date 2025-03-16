package com.fts.funder.service;

import com.fts.funder.model.Idea;
import com.fts.funder.model.User;
import com.fts.funder.model.Vote;
import com.fts.funder.repository.IdeaRepository;
import com.fts.funder.repository.UserRepository;
import com.fts.funder.repository.VoteRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VoteServices {

    private final VoteRepository voteRepository;
    private final UserRepository userRepository;
    private final IdeaRepository ideaRepository;

    public VoteServices(VoteRepository voteRepository, UserRepository userRepository, IdeaRepository ideaRepository) {
        this.voteRepository = voteRepository;
        this.userRepository = userRepository;
        this.ideaRepository = ideaRepository;
    }


    @Transactional
    public String addVote(int userId,int idea_id,Vote vote){
        Idea idea = ideaRepository.findById(idea_id)
                .orElseThrow(() -> new RuntimeException("Idea not found"));

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Optional<Vote> existingVote = voteRepository.findByUserAndIdea(user, idea);

        if (existingVote.isPresent()) {
            throw new RuntimeException("User has already voted on this idea.");
        }

        // 1️⃣ Save the vote
        Vote vote1 = new Vote(vote.getVoteType(), user, idea);
        voteRepository.save(vote1);  // ✅ This is important

        if (vote.getVoteType() == Vote.VoteType.AGREE) {
            idea.setApprovals(idea.getApprovals() + 1);
        } else if (vote.getVoteType() == Vote.VoteType.DISAGREE) {
            idea.setDisapprovals(idea.getDisapprovals() + 1);
        }

        ideaRepository.save(idea);
        return "vote added";
    }

}
