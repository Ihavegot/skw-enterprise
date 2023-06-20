package com.bookstore.bookstore.controller;

import com.bookstore.bookstore.DTO.DShoppingCart;
import com.bookstore.bookstore.model.ShoppingCarts;
import com.bookstore.bookstore.service.ShoppingCartsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@SecurityRequirement(name = "security_auth")
@RequestMapping(value = "/cart")
public class ShoppingCartsController {
    private final ShoppingCartsService shoppingCartsService;
    @GetMapping("{uid}")
    @Operation(summary = "Get cart by user id")
    @PreAuthorize("@customersService.getSingleCustomer(#uid).get().username == authentication.name or hasRole('ROLE_ADMIN')")
    public Optional<ShoppingCarts> getSingleCart(@PathVariable long uid){
        return shoppingCartsService.getCart(uid);
    }
    @PatchMapping("/add")
    @Operation(summary = "Add item to cart")
    @PreAuthorize("@customersService.getSingleCustomer(@customersService.getCurrentUid()).get().username == authentication.name or hasRole('ROLE_ADMIN')")
    public ShoppingCarts addToCart(@RequestBody DShoppingCart dShoppingCartList){
        return shoppingCartsService.addToCart(dShoppingCartList);
    }
    @PatchMapping("/remove")
    @Operation(summary = "Remove item from cart")
    @PreAuthorize("@customersService.getSingleCustomer(@customersService.getCurrentUid()).get().username == authentication.name or hasRole('ROLE_ADMIN')")
    public ShoppingCarts removeFromCart(@RequestBody DShoppingCart dShoppingCartList){
        return shoppingCartsService.removeFromCart(dShoppingCartList);
    }
    @PatchMapping("/clean")
    @Operation(summary = "Clear cart")
    @PreAuthorize("@customersService.getSingleCustomer(@customersService.getCurrentUid()).get().username == authentication.name or hasRole('ROLE_ADMIN')")
    public ShoppingCarts emptyCart(){
        return shoppingCartsService.emptyCart();
    }
}
