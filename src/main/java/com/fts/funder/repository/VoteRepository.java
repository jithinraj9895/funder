package com.fts.funder.repository;

import com.fts.funder.model.Idea;
import com.fts.funder.model.User;
import com.fts.funder.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VoteRepository extends JpaRepository<Vote,Integer> {
    Optional<Vote> findByUserAndIdea(User user, Idea idea);
}
