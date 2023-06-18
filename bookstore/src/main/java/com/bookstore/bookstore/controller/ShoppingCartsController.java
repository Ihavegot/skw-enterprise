package com.bookstore.bookstore.controller;

import com.bookstore.bookstore.DTO.DShoppingCart;
import com.bookstore.bookstore.model.ShoppingCarts;
import com.bookstore.bookstore.service.ShoppingCartsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ShoppingCartsController {
    private final ShoppingCartsService shoppingCartsService;
    @GetMapping("/shoppingCarts/{id}")
    public Optional<ShoppingCarts> getSingleCart(@PathVariable long id){
        return shoppingCartsService.getCart(id);
    }
    @PostMapping("/shoppingCarts/{uid}")
    public ShoppingCarts addToCart(@PathVariable long uid, @RequestBody List<DShoppingCart> dShoppingCartList){
        return shoppingCartsService.addToCart(uid, dShoppingCartList);
    }
}
