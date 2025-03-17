package com.fts.funder.repository;

import com.fts.funder.model.Idea;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IdeaRepository extends JpaRepository<Idea,Integer> {
    List<Idea> findAllByOrderByIdAsc();
}
