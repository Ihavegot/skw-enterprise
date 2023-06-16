package com.bookstore.bookstore.controller;

import com.bookstore.bookstore.DTO.DOrders;
import com.bookstore.bookstore.model.Orders;
import com.bookstore.bookstore.service.OrdersService;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class OrdersController {
    private final OrdersService ordersService;
    // Only logged admin
    @GetMapping("/orders")
    public Page<Orders> getAllOrders(@ParameterObject Pageable pageable){
        return ordersService.getAllUsersOrders(pageable);
    }
    // Only logged admin
    @GetMapping("/orders/{uid}")
    public Page<Orders> getSingleOrder(@PathVariable long uid, @ParameterObject Pageable pageable){
        return ordersService.getSingleUserOrders(uid, pageable);
    }
    // Only logged user
    @PostMapping("/orders")
    public Orders addOrders(@RequestBody DOrders dOrder){
        return ordersService.addOrders(dOrder);
    }
    // Only logged admin
    @DeleteMapping("/orders/{id}")
    public void deleteOrders(@PathVariable long id){
        ordersService.deleteOrders(id);
    }
}
