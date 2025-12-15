package com.example.integradora.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.integradora.dto.LoanRequest;
import com.example.integradora.model.Loan;
import com.example.integradora.service.LoanService;

@RestController
@RequestMapping("/api/loans")
public class LoanController {

    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    //se hace el prestamo
    @PostMapping
    public String createLoan(@RequestBody LoanRequest request) {
        return loanService.processLoanRequest(request);
    }

    //regresa el Libro
    @PostMapping("/{id}/return")
    public String returnBook(@PathVariable int id) {
        return loanService.returnBook(id);
    }

    //prestamos activos
    @GetMapping("/active")
    public Loan[] getActiveLoans() {
        return loanService.getActiveLoans();
    }

    //ver historial de prestamos de un usuario
    @GetMapping("/user/{userId}")
    public Loan[] getUserLoans(@PathVariable int userId) {
        return loanService.getLoansByUserId(userId);
    }

    // ---Flujo E---

    // Ver historial completo
    @GetMapping("/history")
    public Object[] getHistory() {
        return loanService.getHistory();
    }

    // Deshacer última acción (Undo)
    @PostMapping("/history/undolast")
    public String undoLastAction() {
        return loanService.undoLastAction();
    }
}