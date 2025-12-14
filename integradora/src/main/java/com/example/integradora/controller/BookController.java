package com.example.integradora.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.integradora.dto.BookRequest;
import com.example.integradora.model.Book;
import com.example.integradora.service.LibraryCatalogService;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final LibraryCatalogService bookService;

    public BookController(LibraryCatalogService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public String createBook(@RequestBody BookRequest request) {
        return bookService.registerBook(request);
    }

    @GetMapping("/catalog")
    public Book[] getBooks() {
        return bookService.fetchCatalog();
    }

    @PutMapping("/{id}")
    public String updateBook(@PathVariable int id, @RequestBody BookRequest request) {
        return bookService.modifyBookInfo(id, request);
    }

    @PatchMapping("/{id}/status")
    public String updateStatus(@PathVariable int id) {
        return bookService.toggleBookStatus(id);
    }

    @GetMapping("/search")
    public Book[] searchBooks(@RequestParam String title) {
        return bookService.searchByTitle(title);
    }
}
