package com.fts.funder.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "ideas")
public class Idea {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String title;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false) // Foreign key to User table
    private User user;

    @Column(columnDefinition = "TEXT") // For longer descriptions
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate = new Date();

    private int approvals;
    private int disapprovals;

    // Getters and Setters (Can use Lombok)
}
