package com.example.demo.service;

import com.example.demo.CommentMapper;
import com.example.demo.dto.CommentDTO;
import com.example.demo.exception.BadRequestException;
import com.example.demo.model.Book;
import com.example.demo.model.Comment;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentServiceImplementation implements CommentService{

    private final CommentRepository commentRepository;
    private final BookRepository bookRepository;
    private final CommentMapper commentMapper;


   @Override
    public Comment saveComment(String id, Comment comment) {
       Optional<Book> book = bookRepository.findById(id);
       if(book.isEmpty()){
           throw new BadRequestException("Book with given id doesn't exist");
       } else {
           Book foundBook = book.get();
           comment.setBook(foundBook);
        return commentRepository.save(comment);
       }
    }
}
