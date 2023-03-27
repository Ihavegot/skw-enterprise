package com.bookstore.bookstore.service;


import com.bookstore.bookstore.model.Books;
import com.bookstore.bookstore.repository.BooksRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BooksService {
    private final BooksRepository booksRepository;

    public List<Books> getAllBooks(){
        return booksRepository.findAll();
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

    public void deleteSingleBook(Books book){
        // This works weird, fix it if u get better solution
        booksRepository.deleteById(book.getId());
    }

}
