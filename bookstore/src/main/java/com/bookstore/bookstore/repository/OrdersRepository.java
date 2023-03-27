package com.bookstore.bookstore.repository;

import com.bookstore.bookstore.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface OrdersRepository extends JpaRepository<Orders, Long> {
    List<Orders> findAllByUserId(long id);
}
