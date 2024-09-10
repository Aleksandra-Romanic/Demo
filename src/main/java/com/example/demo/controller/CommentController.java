package com.example.demo.controller;

import com.example.demo.model.Comment;
import com.example.demo.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;


    @PostMapping("/{id}")
    public Comment saveComment( @PathVariable String id, @RequestBody Comment comment) {
        return commentService.saveComment(id, comment);

    }

    @GetMapping
    public List<Comment> returnAllComments(){
        return commentService.returnAll();
    }
}
