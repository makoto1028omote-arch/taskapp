package com.example.taskapp;

public class Task {
    private static int counter = 1;

    private int id;
    private String title;
    private boolean done;

    public Task(String title) {
        this.id = counter++;
        this.title = title;
        this.done = false;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public boolean isDone() { return done; }
    public void setDone(boolean done) { this.done = done; }
}
