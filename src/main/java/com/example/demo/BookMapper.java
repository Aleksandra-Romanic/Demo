package com.example.demo;

import com.example.demo.dto.BookDTO;
import com.example.demo.model.Book;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookDTO bookTobookDTO(Book book);
    Book BookDTOtoBook(BookDTO bookDTO);
}
