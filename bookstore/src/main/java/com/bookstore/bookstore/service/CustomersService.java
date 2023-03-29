package com.bookstore.bookstore.service;

import com.bookstore.bookstore.model.Customers;
import com.bookstore.bookstore.repository.CustomersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomersService {
    private final CustomersRepository customersRepository;
    public Optional<Customers> getSingleCustomer(long id){
        return customersRepository.findById(id);
    }
}
