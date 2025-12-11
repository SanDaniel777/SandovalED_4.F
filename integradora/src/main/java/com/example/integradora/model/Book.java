package com.example.integradora.model;

import com.example.integradora.structures.ArrayQueue;

public class Book {

    private int id;
    private String title;
    private int availableCopies;
    private boolean activo; 
    private ArrayQueue<User> waitingList; 

    public Book() {
    }

    public Book(int id, String title, int copies) {
        this.id = id;
        this.title = title;
        this.availableCopies = copies;
        this.waitingList = new ArrayQueue<>();
        this.activo = true;
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

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public ArrayQueue<User> getWaitingList() {
        return waitingList;
    }

    public void setWaitingList(ArrayQueue<User> waitingList) {
        this.waitingList = waitingList;
    }

    
}