package com.monolith.controller;

import com.monolith.dto.request.BookUpdateRequestDto;
import com.monolith.dto.response.FindAllByBookResponseDto;
import com.monolith.repository.entity.Book;
import com.monolith.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import static com.monolith.constants.EndPointList.*;
@RestController
@RequestMapping(BOOK)
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping(SAVE)
    public ResponseEntity<Book> save(Book book){
        bookService.save(book);
        return ResponseEntity.ok(book);
    }
    @GetMapping(FIND_ALL)
    public ResponseEntity<List<Book>> findAll(){
        List<Book> result = bookService.findAll();
        return ResponseEntity.ok(result);
    }
    @GetMapping(FIND_BY_ID)
    public ResponseEntity<Optional<Book>> findById(Long id){
        Optional<Book> result = bookService.findById(id);
        return ResponseEntity.ok(result);
    }
    @GetMapping(FIND_BY_NAME)
    public ResponseEntity<List<FindAllByBookResponseDto>> findAllBookByName(String name){
        List<FindAllByBookResponseDto> result = bookService.findAllBookByName(name);
        return ResponseEntity.ok(result);
    }
    @GetMapping(UPDATE)
    public ResponseEntity<Book> update(BookUpdateRequestDto dto){
        bookService.update(dto);
        return ResponseEntity.ok().build();
    }


}
