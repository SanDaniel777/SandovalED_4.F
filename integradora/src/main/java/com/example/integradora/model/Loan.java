package com.example.integradora.model;

public class Loan {
    private int id;
    private int bookId;
    private int userId;
    private boolean active; // true = prestado, false = devuelto

    public Loan(int id, int bookId, int userId) {
        this.id = id;
        this.bookId = bookId;
        this.userId = userId;
        this.active = true; 
    }

    public Loan() {}

    public int getId() { 
        return id;
     }
    public void setId(int id) {
         this.id = id; 
        }

    public int getBookId() { 
        return bookId; 
    }
    public void setBookId(int bookId) { 
        this.bookId = bookId; 
    }

    public int getUserId() {
         return userId;
         }
    public void setUserId(int userId) { 
        this.userId = userId; 
    }
    
    public boolean isActive() { 
        return active; 
    }
    public void setActive(boolean active) { 
        this.active = active; 
    }
}
