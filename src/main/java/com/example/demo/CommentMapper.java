package com.example.demo;

import com.example.demo.dto.CommentDTO;
import com.example.demo.model.Comment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    CommentDTO commentToCommentDTO(Comment comment);
    Comment CommentDTOToComment(CommentDTO commentDTO);
}
