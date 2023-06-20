package com.bookstore.bookstore.repository;

import com.bookstore.bookstore.model.CartItems;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartItemsRepository extends JpaRepository<CartItems, Long> {
    void deleteById(long id);
}
