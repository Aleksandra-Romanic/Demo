package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "comment")
@Setter
@Getter
@AllArgsConstructor
public class Comment {

    @Id
    private String commentID;
    private String comment;

   @DBRef
    private Book book;
}
