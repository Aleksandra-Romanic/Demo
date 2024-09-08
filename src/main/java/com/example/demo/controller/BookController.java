package com.example.demo.controller;

import com.example.demo.dto.BookDTO;
import com.example.demo.model.Book;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public Book saveBook(@RequestBody Book book) {
        return bookService.saveBook(book);

    }

    @GetMapping
    public List<Book> returnAllBooks(){
        return bookService.returnAll();
    }

    @PutMapping("{id}")
    public void updateBook(@PathVariable Integer id,@RequestBody BookDTO bookDTO){
        bookService.updateBook(id, bookDTO);
    }

    @DeleteMapping("{id}")
    public void deleteBook(@PathVariable Integer id){
        bookService.deleteBook(id);
    }



}
