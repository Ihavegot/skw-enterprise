package com.bookstore.bookstore.repository;

import com.bookstore.bookstore.model.CartItems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemsRepository extends JpaRepository<CartItems, Long> {
}
