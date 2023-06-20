package com.bookstore.bookstore.controller;

import com.bookstore.bookstore.DTO.DBooks;
import com.bookstore.bookstore.model.Books;
import com.bookstore.bookstore.service.BooksService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.context.annotation.Description;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/books")
public class BooksController {
    private final BooksService booksService;

    // Everyone
    @GetMapping
    @Operation(summary = "Get all books")
    public Page<Books> getAllBooks(@ParameterObject Pageable pageable){
        return booksService.getAllBooks(pageable);
    }
    // Everyone
    @GetMapping("{id}")
    @Operation(summary = "Get single book by book id")
    public Books getSingleBook(@PathVariable long id){
        return booksService.getSingleBook(id);
    }
    // Only logged admin
    @PostMapping
    @Operation(summary = "Add book")
    public Books addSingleBook(@RequestBody DBooks dBooks){
        return booksService.addSignleBook(dBooks);
    }
    // Only logged admin
    @PatchMapping("{id}")
    @Operation(summary = "Update book by book id")
    public Optional<Books> updateSingleBook(@PathVariable Long id, @RequestBody DBooks dBooks){
        return booksService.updateSingleBook(id, dBooks);
    }
    // Only logged admin
    @DeleteMapping("{id}")
    @Operation(summary = "Delete book by book id")
    public void deleteSingleBook(@PathVariable long id){
        booksService.deleteSingleBook(id);
    }

}
