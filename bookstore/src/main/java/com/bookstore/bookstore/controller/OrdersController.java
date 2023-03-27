package com.bookstore.bookstore.controller;

import com.bookstore.bookstore.model.Orders;
import com.bookstore.bookstore.service.OrdersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrdersController {
    private final OrdersService ordersService;
    @GetMapping("/orders/{id}")
    public List<Orders> getOrders(@PathVariable long id){
        return ordersService.getOrders(id);
    }
    @PostMapping("/addOrders")
    public Orders addOrders(@RequestBody Orders order){
        return ordersService.addOrders(order);
    }
}
