package com.bookstore.bookstore.service;

import com.bookstore.bookstore.model.Customers;
import com.bookstore.bookstore.repository.CustomersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CustomersService {
    private final CustomersRepository customersRepository;
    public Optional<Customers> getSingleCustomer(long id){
        return customersRepository.findById(id);
    }
    public Optional<Customers> findByUsername(String username){
        return customersRepository.findByUsername(username);
    }
}
