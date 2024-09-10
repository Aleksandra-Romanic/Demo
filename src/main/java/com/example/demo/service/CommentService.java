package com.example.demo.service;

import com.example.demo.model.Comment;

import java.util.List;

public interface CommentService {

    Comment saveComment(String id, Comment comment);

    List<Comment> returnAll();
}
