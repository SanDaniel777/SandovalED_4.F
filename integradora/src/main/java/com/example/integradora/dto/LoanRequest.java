package com.example.integradora.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoanRequest {
    
    @JsonProperty("bookId")
    private int bookId;
    
    @JsonProperty("userId")
    private int userId;

    public LoanRequest() {}

    public int getBookId() { return bookId; }
    public void setBookId(int bookId) { this.bookId = bookId; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }
}
