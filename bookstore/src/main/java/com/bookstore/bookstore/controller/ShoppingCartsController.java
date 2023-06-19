package com.bookstore.bookstore.controller;

import com.bookstore.bookstore.DTO.DShoppingCart;
import com.bookstore.bookstore.model.ShoppingCarts;
import com.bookstore.bookstore.service.ShoppingCartsService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Description;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ShoppingCartsController {
    private final ShoppingCartsService shoppingCartsService;
    @GetMapping("/shoppingCarts/{uid}")
    @Operation(summary = "Get cart by user id")
    public Optional<ShoppingCarts> getSingleCart(@PathVariable long uid){
        return shoppingCartsService.getCart(uid);
    }
    // TODO: delete uid variable, get uid in service
    @PostMapping("/shoppingCarts/{uid}")
    @Operation(summary = "Add item to cart")
    public ShoppingCarts addToCart(@PathVariable long uid, @RequestBody List<DShoppingCart> dShoppingCartList){
        return shoppingCartsService.addToCart(uid, dShoppingCartList);
    }
    @PatchMapping("shoppingCart/{uid}")
    @Operation(summary = "Clear cart")
    public ShoppingCarts emptyCart(@PathVariable long uid){
        return shoppingCartsService.emptyCart(uid);
    }
    // TODO: edit cart
}
