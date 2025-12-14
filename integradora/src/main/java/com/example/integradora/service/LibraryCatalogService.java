package com.example.integradora.service;

import org.springframework.stereotype.Service;

import com.example.integradora.dto.BookRequest;
import com.example.integradora.model.Book;
import com.example.integradora.structures.Node;
import com.example.integradora.structures.SinglyLinkedList;

@Service
public class LibraryCatalogService {
    private SinglyLinkedList<Book> bookCatalog = new SinglyLinkedList<>();

    //Flujo A bby
    //Se registran los libros
    public String registerBook(BookRequest request) {
        Book newBook = new Book(request.getId(), request.getTitle(), request.getCopies());
        bookCatalog.add(newBook);
        return "Libro '" + newBook.getTitle() + "' registrado con éxito en el servicio.";
    }

    // se obtienen los libros 
    public Book[] fetchCatalog() {
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

    public String modifyBookInfo(int id, BookRequest request) {
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

    //baja logica del libro 
    public String toggleBookStatus(int id) {
        
        Node<Book> current = bookCatalog.head;
        while (current != null) {
            if (current.data.getId() == id) {
               
                boolean nuevoEstado = !current.data.isEnabled();
                current.data.setEnabled(nuevoEstado);

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