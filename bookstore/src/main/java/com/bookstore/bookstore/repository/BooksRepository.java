package com.bookstore.bookstore.repository;

import com.bookstore.bookstore.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository extends JpaRepository<Books, Long> {
}
