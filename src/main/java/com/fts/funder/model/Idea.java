package com.fts.funder.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "ideas")
public class Idea {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String title;

    @ManyToOne
    @JoinColumn(name = "user_id") // Foreign key to User table
    private User user;

    @Column(columnDefinition = "TEXT") // For longer descriptions
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate = new Date();

    @Column
    private int approvals;

    @Column
    private int disapprovals;

    // Getters and Setters (Can use Lombok)
}
