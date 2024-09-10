package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "book")
@Getter
@Setter
@AllArgsConstructor
public class Book {

    @Id
    private String bookID;
    private String name;
    private String author;

}
