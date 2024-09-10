package com.example.demo.service;

import com.example.demo.dto.BookDTO;
import com.example.demo.model.Book;

import java.util.List;

public interface BookService {

    Book saveBook(Book book);

    List<Book> returnAll();

    void deleteBook(String id);

    void updateBook(String id, BookDTO bookDTO);
}
