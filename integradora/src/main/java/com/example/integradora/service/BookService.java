package com.example.integradora.service;

import org.springframework.stereotype.Service;

import com.example.integradora.dto.BookRequest;
import com.example.integradora.model.Book;
import com.example.integradora.structures.Node;
import com.example.integradora.structures.SinglyLinkedList;

@Service
public class BookService {
    private SinglyLinkedList<Book> bookCatalog = new SinglyLinkedList<>();

    //Se registran los libros
    public String addBook(BookRequest request) {
        Book newBook = new Book(request.getId(), request.getTitle(), request.getCopies());
        bookCatalog.add(newBook);
        return "Libro '" + newBook.getTitle() + "' registrado con éxito.";
    }

    // se obtienen los libros 
    public Book[] getAllBooks() {
        int count = 0;
        Node<Book> temp = bookCatalog.head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }

        Book[] booksArray = new Book[count];
        temp = bookCatalog.head;
        for (int i = 0; i < count; i++) {
            booksArray[i] = temp.data;
            temp = temp.next;
        }
        return booksArray;
    }

    public String updateBook(int id, BookRequest request) {
        Node<Book> current = bookCatalog.head;
        while (current != null) {
            if (current.data.getId() == id) {
                current.data.setTitle(request.getTitle());
                current.data.setAvailableCopies(request.getCopies());
                return "Libro actualizado: " + current.data.getTitle();
            }
            current = current.next;
        }
        return "Error: Libro no encontrado.";
    }

    public String toggleBookStatus(int id) {
        System.out.println("--- INICIANDO PATCH PARA ID: " + id + " ---");
        
        Node<Book> current = bookCatalog.head;
        while (current != null) {
            if (current.data.getId() == id) {
                System.out.println("Libro encontrado: " + current.data.getTitle());
                System.out.println("Estado ANTES del cambio: " + current.data.isActivo());

                boolean nuevoEstado = !current.data.isActivo();
                current.data.setActivo(nuevoEstado);
                
                System.out.println("Estado DESPUÉS del cambio: " + current.data.isActivo());
                System.out.println("----------------------------------------");

                return "Status actualizado a: " + (nuevoEstado ? "ACTIVO" : "INACTIVO");
            }
            current = current.next;
        }
        return "Error: Libro no encontrado.";
    }

    // buscar por título
    public Book[] searchByTitle(String title) {
        int count = 0;
        Node<Book> temp = bookCatalog.head;
        while (temp != null) {
            if (temp.data.getTitle().toLowerCase().contains(title.toLowerCase())) {
                count++;
            }
            temp = temp.next;
        }

        Book[] results = new Book[count];
        int index = 0;
        temp = bookCatalog.head;
        while (temp != null) {
            if (temp.data.getTitle().toLowerCase().contains(title.toLowerCase())) {
                results[index] = temp.data;
                index++;
            }
            temp = temp.next;
        }
        return results;
    }

    public Book getBookById(int id) {
        Node<Book> current = bookCatalog.head;
        while (current != null) {
            if (current.data.getId() == id) {
                return current.data; 
            }
            current = current.next;
        }
        return null; 
    }
}