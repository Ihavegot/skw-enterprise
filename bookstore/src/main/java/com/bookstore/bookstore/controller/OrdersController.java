package com.bookstore.bookstore.controller;

import com.bookstore.bookstore.model.Orders;
import com.bookstore.bookstore.service.OrdersService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrdersController {
    private final OrdersService ordersService;
    @GetMapping("/orders/{offset}/{size}")
    public Page<Orders> getAllOrders(@PathVariable int offset, @PathVariable int size){
        return ordersService.getAllUsersOrders(offset, size);
    }
    @GetMapping("/orders/uid/{uid}")
    public List<Orders> getSingleOrder(@PathVariable long uid){
        return ordersService.getSingleUserOrders(uid);
    }
    @PostMapping("/orders")
    public Orders addOrders(@RequestBody Orders order){
        return ordersService.addOrders(order);
    }
    @DeleteMapping("/orders/{id}")
    public void deleteOrders(@PathVariable long id){
        ordersService.deleteOrders(id);
    }
}
