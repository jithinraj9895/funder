package com.fts.funder.repository;

import com.fts.funder.model.Idea;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IdeaRepository extends JpaRepository<Idea,Integer> {
    List<Idea> findAllByOrderByIdAsc();

    @Query("SELECT i, (i.approvals - i.disapprovals) AS ranking FROM Idea i ORDER BY ranking DESC")
    List<Object[]> findTopIdeasByRanking(Pageable pageable);
}
