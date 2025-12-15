package com.example.integradora.service;

import org.springframework.stereotype.Service;

import com.example.integradora.dto.LoanRequest;
import com.example.integradora.model.Book;
import com.example.integradora.model.HistoryAction;
import com.example.integradora.model.Loan;
import com.example.integradora.model.User;
import com.example.integradora.structures.ArrayQueue;
import com.example.integradora.structures.ArrayStack;
import com.example.integradora.structures.Node;
import com.example.integradora.structures.SinglyLinkedList;

@Service
public class LoanService {

    private final LibraryCatalogService bookService;
    private final UserService userService;

    private SinglyLinkedList<Loan> activeLoans = new SinglyLinkedList<>();
    private ArrayStack<HistoryAction> historyStack = new ArrayStack<>(100);

    private int nextLoanId = 1;

    public LoanService(LibraryCatalogService bookService, UserService userService) {
        this.bookService = bookService;
        this.userService = userService;
    }

    public String processLoanRequest(LoanRequest request) {

        Book book = bookService.getBookById(request.getBookId());
        User user = userService.getUserById(request.getUserId());

        if (book == null)
            return "Libro no encontrado";

        if (user == null)
            return "Usuario no encontrado";

        if (book.getAvailableCopies() > 0) {

            int previousCopies = book.getAvailableCopies();
            book.setAvailableCopies(previousCopies - 1);

            Loan loan = new Loan(
                    nextLoanId++,
                    book.getId(),
                    user.getId()
            );

            activeLoans.add(loan);

            HistoryAction h = new HistoryAction();
            h.setActionType("CREATE_LOAN");
            h.setLoanId(loan.getId());
            h.setBookId(book.getId());
            h.setUserId(user.getId());
            h.setPreviousAvailableCopies(previousCopies);

            historyStack.push(h);

            return "Préstamo creado correctamente";
        }

        book.getWaitingList().offer(user.getId());

        HistoryAction h = new HistoryAction();
        h.setActionType("ADD_TO_WAITLIST");
        h.setBookId(book.getId());
        h.setUserId(user.getId());

        historyStack.push(h);

        return "No hay copias disponibles. Usuario agregado a lista de espera";
    }

    public String returnBook(int loanId) {

        Loan loan = findLoanById(loanId);
        if (loan == null)
            return "Préstamo no encontrado";

        if (!loan.isActive())
            return "El préstamo ya fue devuelto";

        loan.setActive(false);

        Book book = bookService.getBookById(loan.getBookId());

        if (!book.getWaitingList().isEmpty()) {

            int nextUserId = book.getWaitingList().poll();

            Loan newLoan = new Loan(
                    nextLoanId++,
                    book.getId(),
                    nextUserId
            );

            activeLoans.add(newLoan);
            return "Libro devuelto y reasignado al siguiente usuario";
        }

        book.setAvailableCopies(book.getAvailableCopies() + 1);
        return "Libro devuelto correctamente";
    }

    public Loan[] getActiveLoans() {

        int count = 0;
        Node<Loan> temp = activeLoans.head;

        while (temp != null) {
            if (temp.data.isActive())
                count++;
            temp = temp.next;
        }

        Loan[] result = new Loan[count];
        int index = 0;
        temp = activeLoans.head;

        while (temp != null) {
            if (temp.data.isActive())
                result[index++] = temp.data;
            temp = temp.next;
        }

        return result;
    }

    public Loan[] getLoansByUserId(int userId) {

        int count = 0;
        Node<Loan> temp = activeLoans.head;

        while (temp != null) {
            if (temp.data.getUserId() == userId && temp.data.isActive())
                count++;
            temp = temp.next;
        }

        Loan[] result = new Loan[count];
        int index = 0;
        temp = activeLoans.head;

        while (temp != null) {
            if (temp.data.getUserId() == userId && temp.data.isActive())
                result[index++] = temp.data;
            temp = temp.next;
        }

        return result;
    }

    public Object[] getHistory() {
        return historyStack.toArray();
    }


    public String undoLastAction() {

        if (historyStack.isEmpty())
            return "No hay acciones para deshacer";

        HistoryAction h = historyStack.pop();

        if (h.getActionType().equals("CREATE_LOAN")) {

            Loan loan = findLoanById(h.getLoanId());
            if (loan != null)
                removeLoan(loan);

            Book book = bookService.getBookById(h.getBookId());
            book.setAvailableCopies(h.getPreviousAvailableCopies());

            return "Se deshizo el préstamo";
        }

        if (h.getActionType().equals("ADD_TO_WAITLIST")) {

            Book book = bookService.getBookById(h.getBookId());
            ArrayQueue<Integer> oldQueue = book.getWaitingList();
            ArrayQueue<Integer> newQueue = new ArrayQueue<>();

            while (!oldQueue.isEmpty()) {
                int u = oldQueue.poll();
                if (u != h.getUserId())
                    newQueue.offer(u);
            }

            book.setWaitingList(newQueue);
            return "Se deshizo la reservación";
        }

        return "Acción no soportada";
    }

    private Loan findLoanById(int id) {
        Node<Loan> temp = activeLoans.head;
        while (temp != null) {
            if (temp.data.getId() == id)
                return temp.data;
            temp = temp.next;
        }
        return null;
    }

    private void removeLoan(Loan loan) {
        Node<Loan> current = activeLoans.head;
        Node<Loan> previous = null;

        while (current != null) {
            if (current.data == loan) {
                if (previous == null)
                    activeLoans.head = current.next;
                else
                    previous.next = current.next;
                return;
            }
            previous = current;
            current = current.next;
        }
    }
}