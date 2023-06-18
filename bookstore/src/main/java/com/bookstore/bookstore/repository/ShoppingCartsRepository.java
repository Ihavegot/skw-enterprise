package com.bookstore.bookstore.repository;

import com.bookstore.bookstore.model.ShoppingCarts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartsRepository extends JpaRepository<ShoppingCarts, Long> {
    ShoppingCarts findByUid(long uid);
}
