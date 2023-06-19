package com.bookstore.bookstore.service;

import com.bookstore.bookstore.DTO.DShoppingCart;
import com.bookstore.bookstore.model.CartItems;
import com.bookstore.bookstore.model.Customers;
import com.bookstore.bookstore.model.ShoppingCarts;
import com.bookstore.bookstore.repository.CustomersRepository;
import com.bookstore.bookstore.repository.ShoppingCartsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ShoppingCartsService {
    private final ShoppingCartsRepository shoppingCartsRepository;
    private final CustomersRepository customersRepository;
    private final BooksService booksService;
    private long getCurrentUid(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Optional<Customers> uid = customersRepository.findByUsername(authentication.getName());
        return uid.map(Customers::getId).orElse(0L);
    }
    public Optional<ShoppingCarts> getCart(long uid){
        return shoppingCartsRepository.findById(uid);
    }
    public ShoppingCarts addToCart(List<DShoppingCart> dShoppingCartList){
        long uid = getCurrentUid();
        ShoppingCarts userCart = shoppingCartsRepository.findByUid(uid);
        userCart.setUid(uid);

        Set<CartItems> cartItemsSet = new HashSet<>();
        for(DShoppingCart dsc:dShoppingCartList){
            CartItems cartItems = new CartItems();
            cartItems.setBooks(booksService.getSingleBook(dsc.getBid()));
            cartItems.setQuantity(dsc.getQuantity());
            cartItemsSet.add(cartItems);
        }
        userCart.setCartItems(cartItemsSet);

        double totalPrice = 0;
        for(CartItems ci:cartItemsSet){
            totalPrice += ci.getBooks().getPrice() * ci.getQuantity();
        }
        userCart.setTotalPrice(totalPrice);

        return shoppingCartsRepository.save(userCart);
    }
    public ShoppingCarts emptyCart(long uid){
        ShoppingCarts userCart = shoppingCartsRepository.findByUid(uid);
        userCart.setTotalPrice(0.0);
        userCart.getCartItems().clear();
        return shoppingCartsRepository.save(userCart);
    }

    public void createCart(long uid){
        ShoppingCarts newShoppingCart = new ShoppingCarts();
        newShoppingCart.setUid(uid);
        newShoppingCart.setTotalPrice(0.0);
        shoppingCartsRepository.save(newShoppingCart);
    }
}
