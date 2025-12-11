package com.example.integradora.dto;

public class BookRequest {
    private int id;
    private String title;
    private int copies;

    
    public BookRequest() {
    }

    
    public BookRequest(int id, String title, int copies) {
        this.id = id;
        this.title = title;
        this.copies = copies;
    }


    public int getId() { return id; }
    public String getTitle() { return title; }
    public int getCopies() { return copies; }
}
