package com.bookstore.bookstore.repository;

import com.bookstore.bookstore.model.Orders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdersRepository extends JpaRepository<Orders, Long> {
    Page<Orders> findAllByUid(long id, Pageable pageable);
}
