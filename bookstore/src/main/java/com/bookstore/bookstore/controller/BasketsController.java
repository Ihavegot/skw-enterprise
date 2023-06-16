package com.bookstore.bookstore.controller;

import com.bookstore.bookstore.DTO.DBaskets;
import com.bookstore.bookstore.model.Baskets;
import com.bookstore.bookstore.service.BasketsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class BasketsController {
    private final BasketsService basketsService;
    @GetMapping("/baskets/{id}")
    public Optional<Baskets> getSingleBasket(@PathVariable long id){
        return basketsService.getSingleBasket(id);
    }
    @PostMapping("/baskets")
    public Baskets addToBasket(@RequestBody DBaskets dBaskets){
        return basketsService.addToBasket(dBaskets);
    }
}
