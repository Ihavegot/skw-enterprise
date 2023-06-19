package com.bookstore.bookstore.controller;

import com.bookstore.bookstore.DTO.DOrderState;
import com.bookstore.bookstore.DTO.DOrders;
import com.bookstore.bookstore.model.Orders;
import com.bookstore.bookstore.service.OrdersService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.context.annotation.Description;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class OrdersController {
    private final OrdersService ordersService;
    // Only logged admin
    @GetMapping("/orders")
    @Operation(summary = "Get all orders")
    public Page<Orders> getAllOrders(@ParameterObject Pageable pageable){
        return ordersService.getAllUsersOrders(pageable);
    }
    // Only logged admin
    @GetMapping("/orders/{uid}")
    @Operation(summary = "Get single customer orders by user id")
    public Page<Orders> getSingleUserOrders(@PathVariable long uid, @ParameterObject Pageable pageable){
        return ordersService.getSingleUserOrders(uid, pageable);
    }
    // Only logged user
    @PostMapping("/orders")
    @Operation(summary = "Add order")
    public Orders addOrders(@RequestBody DOrders dOrder){
        return ordersService.addOrders(dOrder);
    }
    // Only logged admin
    @DeleteMapping("/orders/{id}")
    @Operation(summary = "Update order by order id")
    public void deleteOrders(@PathVariable long id){
        ordersService.deleteOrders(id);
    }
    // Only logged admin
    @PatchMapping("orders/{id}")
    @Operation(summary = "Update order by order id")
    public Orders updateOrderState(@PathVariable long id, @RequestBody DOrderState state){
        return ordersService.updateOrderState(id, state);
    }
}
