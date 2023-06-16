package com.bookstore.bookstore.service;

import com.bookstore.bookstore.DTO.DBaskets;
import com.bookstore.bookstore.model.Baskets;
import com.bookstore.bookstore.model.Books;
import com.bookstore.bookstore.model.Customers;
import com.bookstore.bookstore.repository.BasketRepository;
import com.bookstore.bookstore.repository.BooksRepository;
import com.bookstore.bookstore.repository.CustomersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BasketsService {
    private final BasketRepository basketRepository;
    private final CustomersRepository customersRepository;
    private final BooksService booksService;
    public Optional<Baskets> getSingleBasket(long id){
        return basketRepository.findById(id);
    }

    public Baskets addToBasket(DBaskets dBaskets){
        Baskets newBasketContent = new Baskets();
        Optional<Customers> uid = customersRepository.findByUsername(SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName()
        );
        newBasketContent.setUid(uid.map(Customers::getId).orElse(0L));
        List<Books> orderedBooks = new ArrayList<>();
        for(Long id: dBaskets.getBooks()){
            orderedBooks.add(booksService.getSingleBook(id));
        }
        newBasketContent.setBooks(orderedBooks);
        return basketRepository.save(newBasketContent);
    }
}
