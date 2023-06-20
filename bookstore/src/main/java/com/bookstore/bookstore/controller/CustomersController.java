package com.bookstore.bookstore.controller;

import com.bookstore.bookstore.DTO.DCustomer;
import com.bookstore.bookstore.model.Customers;
import com.bookstore.bookstore.service.CustomersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@SecurityRequirement(name = "security_auth")
@RequestMapping(value = "/customers")
public class CustomersController {
    private final CustomersService customersService;
    @GetMapping
    @Operation(summary = "Get all customers")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Page<Customers> getAllCustomers(@ParameterObject Pageable pageable){
        return customersService.getAllCustomers(pageable);
    }
    @GetMapping("{id}")
    @Operation(summary = "Get single customer by user id")
    @PreAuthorize("@customersService.getSingleCustomer(#id).get().username == authentication.name or hasRole('ROLE_ADMIN')")
    public Optional<Customers> getSingleCustomer(@PathVariable long id){
        return customersService.getSingleCustomer(id);
    }
    @PostMapping
    @Operation(summary = "Add customer")
    public Customers addCustomer(@RequestBody DCustomer dCustomer){
        return customersService.addCustomer(dCustomer);
    }
    @DeleteMapping("{id}")
    @Operation(summary = "Delete customer by user id")
    @PreAuthorize("@customersService.getSingleCustomer(#id).get().username == authentication.name or hasRole('ROLE_ADMIN')")
    public void deleteCustomer(@PathVariable long id){
        customersService.deleteCustomer(id);
    }
    @PatchMapping("{id}")
    @Operation(summary = "Update customer by user id")
    @PreAuthorize("@customersService.getSingleCustomer(#id).get().username == authentication.name or hasRole('ROLE_ADMIN')")
    public Optional<Customers> updateCustomer(@PathVariable long id, @RequestBody DCustomer dCustomer){
        return customersService.updateCustomer(id, dCustomer);
    }
}
