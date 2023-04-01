package com.bookstore.bookstore.service;


import com.bookstore.bookstore.model.Books;
import com.bookstore.bookstore.repository.BooksRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BooksService {
    private final BooksRepository booksRepository;

    public Page<Books> getAllBooks(int offset, int size){
        return  booksRepository.findAll(PageRequest.of(offset, size));
    }

    public Books getSingleBook(long id){
        return booksRepository.findById(id).orElseThrow();
    }

    public Books addSignleBook(Books book){
        return booksRepository.save(book);
    }

    public Optional<Books> updateSingleBook(Books book){
        return booksRepository.findById(book.getId()).map(b -> {
            if (book.getAuthor() != null) {
                b.setAuthor(book.getAuthor());
            }
            if(book.getTitle() != null){
                b.setTitle(book.getTitle());
            }
            if(book.getGenre() != null){
                b.setGenre(book.getGenre());
            }
            return booksRepository.save(b);
        });
    }

    public void deleteSingleBook(long id){
        booksRepository.deleteById(id);
    }

}
