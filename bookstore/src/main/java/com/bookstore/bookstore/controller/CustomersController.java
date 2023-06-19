package com.bookstore.bookstore.controller;

import com.bookstore.bookstore.model.Customers;
import com.bookstore.bookstore.service.CustomersService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Description;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class CustomersController {
    private final CustomersService customersService;
    @GetMapping("/customers/{id}")
    @Operation(summary = "Get single customer by user id")
    public Optional<Customers> getSingleCustomer(@PathVariable long id){
        return customersService.getSingleCustomer(id);
    }
    // TODO: create, update, delete user
}
