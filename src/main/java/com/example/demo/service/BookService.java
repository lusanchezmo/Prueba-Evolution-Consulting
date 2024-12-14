package com.example.demo.service;

import com.example.demo.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final List<Book> books = new ArrayList<>();

    public BookService() {
        // Datos iniciales quemados
        books.add(new Book(1, "Cien años de soledad", "Gabriel García Márquez", "Ficción"));
        books.add(new Book(2, "1984", "George Orwell", "Distopía"));
        books.add(new Book(3, "El principito", "Antoine de Saint-Exupéry", "Fantasía"));
    }

    public List<Book> getAllBooks() {
        return books;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public Book getBookById(int id) {
        Optional<Book> book = books.stream().filter(b -> b.getId() == id).findFirst();
        return book.orElse(null);
    }
}
