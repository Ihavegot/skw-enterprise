package com.bookstore.bookstore.repository;

import com.bookstore.bookstore.model.Customers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomersRepository extends JpaRepository<Customers, Long> {
}
