package com.example.taskapp;

import jakarta.persistence.*;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private boolean done;

    public Task() {}

    public Task(String title) {
        this.title = title;
        this.done = false;
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public boolean isDone() { return done; }
    public void setDone(boolean done) { this.done = done; }
}
