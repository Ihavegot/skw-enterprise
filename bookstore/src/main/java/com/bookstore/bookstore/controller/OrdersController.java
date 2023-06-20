package com.bookstore.bookstore.controller;

import com.bookstore.bookstore.DTO.DOrderState;
import com.bookstore.bookstore.DTO.DOrders;
import com.bookstore.bookstore.model.Orders;
import com.bookstore.bookstore.service.CustomersService;
import com.bookstore.bookstore.service.OrdersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.context.annotation.Description;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@SecurityRequirement(name = "security_auth")
@RequestMapping(value = "/orders")
public class OrdersController {
    private final OrdersService ordersService;
    private final CustomersService customersService;
    @GetMapping
    @Operation(summary = "Get all orders")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Page<Orders> getAllOrders(@ParameterObject Pageable pageable){
        return ordersService.getAllUsersOrders(pageable);
    }
    @GetMapping("{uid}")
    @Operation(summary = "Get single customer orders by user id")
    @PreAuthorize("@customersService.getSingleCustomer(#uid).get().username == authentication.name or hasRole('ROLE_ADMIN')")
    public Page<Orders> getSingleUserOrders(@PathVariable long uid, @ParameterObject Pageable pageable){
        return ordersService.getSingleUserOrders(uid, pageable);
    }
    @PostMapping
    @Operation(summary = "Add order")
    @PreAuthorize("hasRole('USER') or hasRole('ROLE_ADMIN')")
    public Orders addOrders(@RequestBody DOrders dOrder){
        return ordersService.addOrders(dOrder);
    }
//    ------------------------------------------------------------------------------------------------------------------
//    @DeleteMapping("/orders/{id}")
//    @Operation(summary = "Delete order by order id")
//    public void deleteOrders(@PathVariable long id){
//        ordersService.deleteOrders(id);
//    }
//    ------------------------------------------------------------------------------------------------------------------
    @PatchMapping("{id}")
    @Operation(summary = "Update order state by order id")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Orders updateOrderState(@PathVariable long id, @RequestBody DOrderState state){
        return ordersService.updateOrderState(id, state);
    }
}
