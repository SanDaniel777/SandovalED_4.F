package com.example.integradora.dto;

public class BookRequest {
    private int id;
    private String title;
    private String author;
    private String publisher;

    private int copies;

    
    public BookRequest() {
    }

    
    public BookRequest(int id, String title, String author, String publisher,int copies) {
        this.id = id;
        this.title = title;
        this.author=author;
        this.publisher=publisher;
        this.copies = copies;
    }


    public int getId() { 
        return id; 
    }
    public String getTitle() { 
        return title; 
    }
    
    public int getCopies() { 
        return copies; 
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

}
