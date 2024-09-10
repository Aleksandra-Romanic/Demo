package com.example.demo.service;

import com.example.demo.model.Comment;

public interface CommentService {

    Comment saveComment(String id, Comment comment);
}
