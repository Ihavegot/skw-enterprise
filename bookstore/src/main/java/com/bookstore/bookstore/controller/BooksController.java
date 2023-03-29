package com.bookstore.bookstore.controller;

import com.bookstore.bookstore.model.Books;
import com.bookstore.bookstore.service.BooksService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class BooksController {
    private final BooksService booksService;

    @GetMapping("/books")
    public List<Books> getAllBooks(){
        // TODO: pagination
        return booksService.getAllBooks();
    }

    @GetMapping("/books/{id}")
    public Books getSingleBook(@PathVariable long id){
        return booksService.getSingleBook(id);
    }

    @PostMapping("/books")
    public Books addSingleBook(@RequestBody Books book){
        return booksService.addSignleBook(book);
    }

    @PutMapping("/books")
    public Optional<Books> updateSingleBook(@RequestBody Books book){
        return booksService.updateSingleBook(book);
    }

    @DeleteMapping("/books/{id}")
    public void deleteSingleBook(@PathVariable long id){
        booksService.deleteSingleBook(id);
    }

}
