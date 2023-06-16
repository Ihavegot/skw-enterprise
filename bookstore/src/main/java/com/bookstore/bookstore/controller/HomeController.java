package com.bookstore.bookstore.controller;

import org.hibernate.metamodel.RepresentationMode;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/")
    public String homePage(){
        return "";
    }
}
