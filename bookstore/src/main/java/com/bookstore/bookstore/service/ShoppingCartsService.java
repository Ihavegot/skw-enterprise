package com.bookstore.bookstore.service;

import com.bookstore.bookstore.DTO.DShoppingCart;
import com.bookstore.bookstore.model.Books;
import com.bookstore.bookstore.model.CartItems;
import com.bookstore.bookstore.model.Customers;
import com.bookstore.bookstore.model.ShoppingCarts;
import com.bookstore.bookstore.repository.CartItemsRepository;
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
    private final CartItemsRepository cartItemsRepository;

    private long getCurrentUid() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Optional<Customers> uid = customersRepository.findByUsername(authentication.getName());
        return uid.map(Customers::getId).orElse(0L);
    }

    public Optional<ShoppingCarts> getCart(long uid) {
        return shoppingCartsRepository.findById(uid);
    }

    private Set<CartItems> addQuantity(long uid, Books book) {
        ShoppingCarts userCart = shoppingCartsRepository.findByUid(uid);
        Set<CartItems> cartItemsSet = userCart.getCartItems();
        for(CartItems ci:cartItemsSet){
            if(ci.getBooks().equals(book)){
                ci.setShoppingCarts(userCart);
                ci.setQuantity(ci.getQuantity()+1);
            }
        }
        return cartItemsSet;
    }
    private boolean checkIfSetContains(long uid, Books book) {
        ShoppingCarts userCart = shoppingCartsRepository.findByUid(uid);
        Set<CartItems> cartItemsSet = userCart.getCartItems();
        for(CartItems ci:cartItemsSet){
            if(ci.getBooks().equals(book)){
                return true;
            }
        }
        return false;
    }
    public ShoppingCarts addToCart(DShoppingCart dShoppingCartList) {
        long uid = getCurrentUid();
        ShoppingCarts userCart = shoppingCartsRepository.findByUid(uid);
        userCart.setUid(uid);

        if(checkIfSetContains(uid, booksService.getSingleBook(dShoppingCartList.getBid()))){
            Set<CartItems> newSet = addQuantity(uid, booksService.getSingleBook(dShoppingCartList.getBid()));
            userCart.setCartItems(newSet);
        }else {
            CartItems cartItems = new CartItems();
            cartItems.setShoppingCarts(userCart);
            cartItems.setBooks(booksService.getSingleBook(dShoppingCartList.getBid()));
            cartItems.setQuantity(dShoppingCartList.getQuantity());
            userCart.getCartItems().add(cartItems);
        }

        double totalPrice = 0;
        for (CartItems ci : userCart.getCartItems()) {
            totalPrice += ci.getBooks().getPrice() * ci.getQuantity();
        }
        userCart.setTotalPrice(totalPrice);

        return shoppingCartsRepository.save(userCart);
    }

    public ShoppingCarts emptyCart() {
        ShoppingCarts userCart = shoppingCartsRepository.findByUid(getCurrentUid());
        userCart.setTotalPrice(0.0);
        for(CartItems ci: userCart.getCartItems()){
            ci.setShoppingCarts(null);
            cartItemsRepository.save(ci);
        }
        return shoppingCartsRepository.save(userCart);
    }

    public ShoppingCarts removeFromCart(DShoppingCart dShoppingCart){
        ShoppingCarts userCart = shoppingCartsRepository.findByUid(getCurrentUid());
        Set<CartItems> newCartItemsSet = new HashSet<>();
        for(CartItems ci: userCart.getCartItems()){
            if(ci.getBooks().getId() == dShoppingCart.getBid()){
                if(ci.getQuantity()-dShoppingCart.getQuantity() > 0){
                    ci.setQuantity(ci.getQuantity()-dShoppingCart.getQuantity());
                    ci.setBooks(booksService.getSingleBook(dShoppingCart.getBid()));
                    newCartItemsSet.add(ci);
                }else{
                    ci.setShoppingCarts(null);
                    cartItemsRepository.save(ci);
                }
            }else{
                newCartItemsSet.add(ci);
            }
            userCart.setTotalPrice(userCart.getTotalPrice() + ci.getBooks().getPrice()*ci.getQuantity());
        }

        double totalPrice = 0;
        for (CartItems ci : newCartItemsSet) {
            totalPrice += ci.getBooks().getPrice() * ci.getQuantity();
        }
        userCart.setTotalPrice(totalPrice);
        userCart.setCartItems(newCartItemsSet);
        return shoppingCartsRepository.save(userCart);
    }

    public void createCart(long uid) {
        ShoppingCarts newShoppingCart = new ShoppingCarts();
        newShoppingCart.setUid(uid);
        newShoppingCart.setTotalPrice(0.0);
        shoppingCartsRepository.save(newShoppingCart);
    }
}
