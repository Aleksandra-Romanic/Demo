package com.example.demo.service;

import com.example.demo.BookMapper;
import com.example.demo.dto.BookDTO;
import com.example.demo.exception.BadRequestException;
import com.example.demo.model.Book;
import org.springframework.stereotype.Service;
import com.example.demo.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImplementation implements BookService{
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public BookServiceImplementation(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    @Override
    public Book saveBook(Book book) {
        Book existingBook = bookRepository.findByName(book.getName());
        if (existingBook != null) {
            throw new BadRequestException("Resource with given name already exist");
        } else {
            return bookRepository.save(book);
        }
    }

    @Override
    public List<Book> returnAll() {
        return bookRepository.findAll();
    }

    @Override
    public void deleteBook(Integer id) {
        Optional<Book> existingBook = bookRepository.findById(id);
        if(existingBook.isPresent()){
            bookRepository.deleteById(id);
        }
        else {
            throw new BadRequestException("Resource with given id doesn't exist");
        }
    }

    @Override
    public void updateBook(Integer id, BookDTO bookDTO) {
        Optional<Book> bookFromDatabase = bookRepository.findById(id);
        if(bookFromDatabase.isPresent()){
           Book newBook = bookFromDatabase.get();
           Book mappedBook = bookMapper.BookDTOtoBook(bookDTO);
           mappedBook.setBookID(newBook.getBookID());
           bookRepository.save(mappedBook);
        }else {
            throw new BadRequestException("Resource with given id doesn't exist");
        }
    }
}
