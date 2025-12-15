package com.example.integradora.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.integradora.model.Book;
import com.example.integradora.model.User;
import com.example.integradora.service.LibraryCatalogService;
import com.example.integradora.service.UserService;

@RestController
@RequestMapping("/api/reservation")
public class ReservationController {

    private final LibraryCatalogService bookService;
    private final UserService userService;

    public ReservationController(LibraryCatalogService bookService, UserService userService) {
        this.bookService = bookService;
        this.userService = userService;
    }

    @GetMapping("/book/{bookId}")
    public Object[] getReservations(@PathVariable int bookId) {
        Book book = bookService.getBookById(bookId);
        if (book == null) return new Object[0];
        
        return book.getWaitingList().toArray();
    }

    //sacar usuario de la cola
    @DeleteMapping
    public String cancelReservation(@RequestParam int userId, @RequestParam int bookId) {
        Book book = bookService.getBookById(bookId);
        User user = userService.getUserById(userId);

        if (book == null) return "Libro no encontrado";
        if (user == null) return "Usuario no encontrado";

        Object[] waiting = book.getWaitingList().toArray();
        User targetUserInQueue = null;
        
        for (Object obj : waiting) {
            if (obj instanceof User) {
                User u = (User) obj;
                if (u.getId() == userId) {
                    targetUserInQueue = u;
                    break;
                }
            }
        }
        
        if (targetUserInQueue != null && book.getWaitingList().remove(targetUserInQueue)) {
             return "Reserva cancelada";
        }
        
        return "El usuario no se encuentra en la lista de espera.";
    }
}
