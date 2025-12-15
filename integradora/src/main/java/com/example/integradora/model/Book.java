package com.example.integradora.model;

import com.example.integradora.structures.ArrayQueue;

public class Book {

    private int id;
    private String title;
    private String author;
    private String publisher;
    private int availableCopies;
    private boolean enabled; 
    private ArrayQueue<User> waitingList; 

    public Book() {
    }

    public Book(int id, String title, String author, String publisher, int copies) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.availableCopies = copies;
        this.waitingList = new ArrayQueue<>();
        this.enabled = true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
    }

    public ArrayQueue<User> getWaitingList() {
        return waitingList;
    }

    public void setWaitingList(ArrayQueue<User> waitingList) {
        this.waitingList = waitingList;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }


    
}