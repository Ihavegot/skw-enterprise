package com.bookstore.bookstore.controller;
import com.bookstore.bookstore.DTO.DOrderState;
import com.bookstore.bookstore.DTO.Order;
import com.bookstore.bookstore.model.CartItems;
import com.bookstore.bookstore.model.Customers;
import com.bookstore.bookstore.model.Orders;
import com.bookstore.bookstore.service.CustomersService;
import com.bookstore.bookstore.service.OrdersService;
import com.bookstore.bookstore.service.PaypalService;
import com.paypal.api.payments.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import com.paypal.base.rest.PayPalRESTException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@SecurityRequirement(name = "security_auth")
public class PaypalController {

    @Autowired
    PaypalService service;

    private final OrdersService ordersService;
    private final PaypalService paypalService;
    public static final String SUCCESS_URL = "pay/success";
    public static final String CANCEL_URL = "pay/cancel";

    @PostMapping("/pay/{oid}")
    public String payment(@PathVariable long oid) {
        try {
            Optional<Orders> order = ordersService.getSingleOrder(oid);
            if(order.isEmpty()){
                return "/";
            }
            Payment payment = paypalService.createPayment(order.get().getTotalPrice(), "PLN", "paypal",
                    "sale", "Bookstore books sales", "http://localhost:8080/" + CANCEL_URL,
                    "http://localhost:8080/" + SUCCESS_URL);

            for(Links link:payment.getLinks()) {
                if(link.getRel().equals("approval_url")) {
                    DOrderState state = new DOrderState();
                    state.setState("PAYED AND AWAITING FOR DELIVERY");
                    ordersService.updateOrderState(oid, state);
                    return link.getHref();
                }
            }

        } catch (PayPalRESTException e) {

            e.printStackTrace();
        }
        return "/";
    }

    @GetMapping(value = CANCEL_URL)
    public String cancelPay() {
        return "/";
    }

    @GetMapping(value = SUCCESS_URL)
    public String successPay(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId) {
        try {
            Payment payment = service.executePayment(paymentId, payerId);
            if (payment.getState().equals("approved")) {
                return payment.toJSON();
            }
        } catch (PayPalRESTException e) {
            System.out.println(e.getMessage());
        }
        return "/";
    }

}