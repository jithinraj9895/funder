package com.fts.funder.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "votes")
@Getter
@Setter
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public enum VoteType{
        AGREE,
        DISAGREE
    }

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private VoteType voteType;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "idea_id",nullable = false)
    private Idea idea;


    public Vote(VoteType voteType, User user, Idea idea) {
        this.voteType = voteType;
        this.user = user;
        this.idea = idea;
    }



}
