package com.bookstore.bookstore.repository;

import com.bookstore.bookstore.model.Customers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomersRepository extends JpaRepository<Customers, Long> {
}