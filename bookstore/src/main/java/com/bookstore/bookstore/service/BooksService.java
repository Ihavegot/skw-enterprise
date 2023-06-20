package com.bookstore.bookstore.service;


import com.bookstore.bookstore.DTO.DBooks;
import com.bookstore.bookstore.model.Books;
import com.bookstore.bookstore.repository.BooksRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BooksService {
    private final BooksRepository booksRepository;

    public Page<Books> getAllBooks(Pageable pageable){
        return booksRepository.findAll(pageable);
    }
    public Books getSingleBook(long id){
        return booksRepository.findById(id).orElseThrow();
    }
    public Books addSignleBook(DBooks dBooks){
        Books newBook = new Books();
        newBook.setTitle(dBooks.getTitle());
        newBook.setAuthor(dBooks.getAuthor());
        newBook.setGenre(dBooks.getGenre());
        newBook.setPrice(dBooks.getPrice());
        return booksRepository.save(newBook);
    }
    public Optional<Books> updateSingleBook(Long id, DBooks dBooks){
        return booksRepository.findById(id).map(b -> {
            if (dBooks.getAuthor() != null) {
                b.setAuthor(dBooks.getAuthor());
            }
            if(dBooks.getTitle() != null){
                b.setTitle(dBooks.getTitle());
            }
            if(dBooks.getGenre() != null){
                b.setGenre(dBooks.getGenre());
            }
            if(dBooks.getPrice() != 0){
                b.setPrice(dBooks.getPrice());
            }
            return booksRepository.save(b);
        });
    }
    public void deleteSingleBook(long id){
        booksRepository.deleteById(id);
    }

}
