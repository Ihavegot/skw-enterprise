package com.bookstore.bookstore.repository;

import com.bookstore.bookstore.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdersRepository extends JpaRepository<Orders, Long> {
    List<Orders> findAllByUid(long id);
}
