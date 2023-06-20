package com.bookstore.bookstore.service;

import com.bookstore.bookstore.DTO.DOrderState;
import com.bookstore.bookstore.DTO.DOrders;
import com.bookstore.bookstore.model.*;
import com.bookstore.bookstore.repository.CustomersRepository;
import com.bookstore.bookstore.repository.OrdersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class OrdersService {
    private final OrdersRepository ordersRepository;
    private final CustomersRepository customersRepository;
    private final ShoppingCartsService shoppingCartsService;
    private long getCurrentUid(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Optional<Customers> uid = customersRepository.findByUsername(authentication.getName());
        return uid.map(Customers::getId).orElse(0L);
    }
    public Page<Orders> getAllUsersOrders(Pageable pageable){
        return ordersRepository.findAll(pageable);
    }
    public Page<Orders> getSingleUserOrders(long uid, Pageable pageable){
        return ordersRepository.findAllByUid(uid, pageable);
    }
    public Orders addOrders(DOrders dOrder){
        Orders newOrder = new Orders();
        newOrder.setUid(getCurrentUid());
        newOrder.setOrderdate(Calendar.getInstance().getTime());
        newOrder.setCity(dOrder.getCity());
        newOrder.setPostcode(dOrder.getPostCode());
        newOrder.setAddress(dOrder.getAddress());
        Optional<ShoppingCarts> userShoppingCart = shoppingCartsService.getCart(getCurrentUid());
        Set<CartItems> cartItemsSet = userShoppingCart.get().getCartItems();
        newOrder.setCartItems(new HashSet<>());
        for(CartItems ci:cartItemsSet){
            newOrder.getCartItems().add(ci);
        }
        newOrder.setTotalPrice(userShoppingCart.get().getTotalPrice());
        newOrder.setStatus("CONFIRMING ORDER");
        shoppingCartsService.emptyCart(getCurrentUid());

        Orders output = ordersRepository.save(newOrder);
        for(CartItems ci:output.getCartItems()){
            ci.setOrders(newOrder);
        }
        return ordersRepository.save(newOrder);
    }
    public Orders updateOrderState(long id, DOrderState state){
        Optional<Orders> orders = ordersRepository.findById(id);
        if(orders.isPresent()){
            orders.get().setStatus(state.getState());
            return ordersRepository.save(orders.get());
        }
        return null;
    }
}
