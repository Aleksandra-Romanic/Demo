package com.example.demo.service;

import com.example.demo.dto.BookDTO;
import com.example.demo.model.Book;

import java.util.List;

public interface BookService {

    Book saveBook(Book book);

    List<Book> returnAll();

    void deleteBook(Integer id);

    void updateBook(Integer id, BookDTO bookDTO);
}
