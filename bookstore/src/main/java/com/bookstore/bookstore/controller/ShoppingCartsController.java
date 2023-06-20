package com.bookstore.bookstore.controller;

import com.bookstore.bookstore.DTO.DShoppingCart;
import com.bookstore.bookstore.model.ShoppingCarts;
import com.bookstore.bookstore.service.ShoppingCartsService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/cart")
public class ShoppingCartsController {
    private final ShoppingCartsService shoppingCartsService;
    @GetMapping("{uid}")
    @Operation(summary = "Get cart by user id")
    public Optional<ShoppingCarts> getSingleCart(@PathVariable long uid){
        return shoppingCartsService.getCart(uid);
    }
    @PatchMapping("/add")
    @Operation(summary = "Add item to cart")
    public ShoppingCarts addToCart(@RequestBody DShoppingCart dShoppingCartList){
        return shoppingCartsService.addToCart(dShoppingCartList);
    }
    @PatchMapping("/remove")
    @Operation(summary = "Remove item from cart")
    public ShoppingCarts removeFromCart(@RequestBody DShoppingCart dShoppingCartList){
        return shoppingCartsService.removeFromCart(dShoppingCartList);
    }
    @PatchMapping("/clean")
    @Operation(summary = "Clear cart")
    public ShoppingCarts emptyCart(){
        return shoppingCartsService.emptyCart();
    }
}
