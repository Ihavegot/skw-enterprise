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
    @GetMapping("/shoppingCarts/{uid}")
    public Optional<ShoppingCarts> getSingleCart(@PathVariable long uid){
        return shoppingCartsService.getCart(uid);
    }
    @PostMapping("/shoppingCarts/{uid}")
    public ShoppingCarts addToCart(@PathVariable long uid, @RequestBody List<DShoppingCart> dShoppingCartList){
        return shoppingCartsService.addToCart(uid, dShoppingCartList);
    }
    @PatchMapping("shoppingCart/{uid}")
    public ShoppingCarts emptyCart(@PathVariable long uid){
        return shoppingCartsService.emptyCart(uid);
    }
    // TODO: edit cart
}
