package com.bookstore.bookstore.repository;

import com.bookstore.bookstore.model.Baskets;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketRepository extends JpaRepository<Baskets, Long> {
}
