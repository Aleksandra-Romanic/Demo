package com.example.demo.controller;

import com.example.demo.dto.CommentDTO;
import com.example.demo.model.Comment;
import com.example.demo.service.CommentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/{id}")
    public Comment saveComment( @PathVariable String id, @RequestBody Comment comment) {
        return commentService.saveComment(id, comment);

    }
}
