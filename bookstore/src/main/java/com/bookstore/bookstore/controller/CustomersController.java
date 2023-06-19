package com.bookstore.bookstore.controller;

import com.bookstore.bookstore.DTO.DCustomer;
import com.bookstore.bookstore.model.Customers;
import com.bookstore.bookstore.service.CustomersService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/customers")
    @Operation(summary = "Add customer")
    public Customers addCustomer(@RequestBody DCustomer dCustomer){
        return customersService.addCustomer(dCustomer);
    }
    @DeleteMapping("/customers/{id}")
    @Operation(summary = "Delete customer by user id")
    public void deleteCustomer(@PathVariable long id){
        customersService.deleteCustomer(id);
    }
    @PatchMapping("/customers/{id}")
    @Operation(summary = "Update customer by user id")
    public Optional<Customers> updateCustomer(@PathVariable long id, @RequestBody DCustomer dCustomer){
        return customersService.updateCustomer(id, dCustomer);
    }
}
