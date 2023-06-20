package com.bookstore.bookstore.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.hibernate.metamodel.RepresentationMode;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SecurityRequirement(name = "security_auth")
public class HomeController {

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/")
    @Operation(summary = "Home controller, links to API endpoints")
    public String homePage(){
        return "{" +
                " 'books': 'http://localhost:8080/books', " +
                " 'customers': 'http://localhost:8080/customers', " +
                " 'shoppingCart': 'http://localhost:8080/shoppingCart', " +
                " 'orders': 'http://localhost:8080/orders'" +
                "}";
    }
}
