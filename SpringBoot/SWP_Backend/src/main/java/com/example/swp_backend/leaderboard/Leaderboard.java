package com.example.swp_backend.leaderboard;

import jakarta.persistence.*;

@Entity
public class Leaderboard {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_seq")
    @SequenceGenerator(name = "book_seq", sequenceName = "book_seq", allocationSize = 1)
    private Long id;

    private String username;
    private int score;

    public Leaderboard() {
    }

    public Leaderboard(Long id, String username, int score) {
        this.id = id;
        this.username = username;
        this.score = score;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
