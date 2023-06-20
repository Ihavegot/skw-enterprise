package com.bookstore.bookstore.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SecurityRequirement(name = "security_auth")
public class HomeController {

}
