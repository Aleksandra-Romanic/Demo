package com.example.demo.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "authors")
@Getter
@Setter
@AllArgsConstructor
public class Author {

    @Id
    private String authorID;
    private String name;
}
