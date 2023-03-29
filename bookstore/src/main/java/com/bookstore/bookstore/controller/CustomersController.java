package com.bookstore.bookstore.controller;

import com.bookstore.bookstore.model.Customers;
import com.bookstore.bookstore.service.CustomersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class CustomersController {
    private final CustomersService customersService;
    @GetMapping("/customers/{id}")
    public Optional<Customers> getSingleCustomer(@PathVariable long id){
        return customersService.getSingleCustomer(id);
    }
}
