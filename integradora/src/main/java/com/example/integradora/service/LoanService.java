package com.example.integradora.service;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

import com.example.integradora.dto.LoanRequest;
import com.example.integradora.model.Book;
import com.example.integradora.model.Loan;
import com.example.integradora.model.User;
import com.example.integradora.structures.ArrayStack;
import com.example.integradora.structures.SinglyLinkedList;

@Service
public class LoanService {

    private final LibraryCatalogService bookService;
    private final UserService userService;
    
    private SinglyLinkedList<Loan> activeLoans = new SinglyLinkedList<>();
    private ArrayStack<String> historyStack = new ArrayStack<>();
    private AtomicInteger loanIdCounter = new AtomicInteger(1);

    public LoanService(LibraryCatalogService bookService, UserService userService) {
        this.bookService = bookService;
        this.userService = userService;
    }

    //proceso del prestamo
    public String processLoanRequest(LoanRequest request) {
        Book book = bookService.getBookById(request.getBookId());
        User user = userService.getUserById(request.getUserId());

        if (book == null) return "Error: Libro no encontrado.";
        if (user == null) return "Error: Usuario no encontrado.";

        if (book.getAvailableCopies() > 0) {
            book.setAvailableCopies(book.getAvailableCopies() - 1);
            
            Loan newLoan = new Loan(loanIdCounter.getAndIncrement(), book.getId(), user.getId());
            activeLoans.add(newLoan); 
            historyStack.push("Usuario " + user.getName() + " pidio prestado el libro " + book.getTitle());
            return "Préstamo creado para " + user.getName();
            
        } else {
            book.getWaitingList().offer(user);
            
            historyStack.push("Usuario " + user.getName() + " agregado a la lista de espera del libro " + book.getTitle());
            return "Sin copias. Haz sido agregado a la lista de espera";
        }
    }

    //proceso del regreso del libros
    public String returnBook(int loanId) {
        Loan loan = findLoanById(loanId);
        
        if (loan == null) return "Error: El prestamo no se encontro.";
        if (!loan.isActive()) return "Error: El libro ya se ha devuelto.";

        loan.setActive(false);
        Book book = bookService.getBookById(loan.getBookId());
        
        historyStack.push("Prestamo " + loanId + " regreso el libro " + book.getTitle());
        if (!book.getWaitingList().isEmpty()) {
            User nextUser = (User) book.getWaitingList().poll(); 
            
            Loan newLoan = new Loan(loanIdCounter.getAndIncrement(), book.getId(), nextUser.getId());
            activeLoans.add(newLoan);
            
            historyStack.push("El libro se reasigno al siguiente usuario" + nextUser.getName());
            
            return "Libro devuelto. Se ha asignado al siguiente usuario";
        } else {
            book.setAvailableCopies(book.getAvailableCopies() + 1);
            return "Libro devuelto.";
        }
    }

    public Loan[] getActiveLoans() {
        int count = 0;
        var temp = activeLoans.head;
        while (temp != null) {
            if (temp.data.isActive()) count++;
            temp = temp.next;
        }

        Loan[] result = new Loan[count];
        int index = 0;
        temp = activeLoans.head;
        while (temp != null) {
            if (temp.data.isActive()) {
                result[index++] = temp.data;
            }
            temp = temp.next;
        }
        return result;
    }

    public Loan[] getLoansByUserId(int userId) {
        int count = 0;
        var temp = activeLoans.head;
        while (temp != null) {
            if (temp.data.getUserId() == userId && temp.data.isActive()) count++;
            temp = temp.next;
        }

        Loan[] result = new Loan[count];
        int index = 0;
        temp = activeLoans.head;
        while (temp != null) {
            if (temp.data.getUserId() == userId && temp.data.isActive()) {
                result[index++] = temp.data;
            }
            temp = temp.next;
        }
        return result;
    }

    private Loan findLoanById(int id) {
        var temp = activeLoans.head;
        while (temp != null) {
            if (temp.data.getId() == id) return temp.data;
            temp = temp.next;
        }
        return null;
    }

    // --- FLUJO E: HISTORIAL Y UNDO ---

    public Object[] getHistory() {
        return historyStack.toArray();
    }

    public String undoLastAction() {
        if (historyStack.isEmpty()) {
            return "El historial está vacío. No hay nada que deshacer.";
        }
        
        String lastAction = historyStack.pop(); 
        return "Acción deshecha (eliminada del historial): " + lastAction;
    }
}