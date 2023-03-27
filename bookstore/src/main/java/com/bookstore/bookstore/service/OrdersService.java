package com.bookstore.bookstore.service;

import com.bookstore.bookstore.model.Orders;
import com.bookstore.bookstore.repository.OrdersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrdersService {
    private final OrdersRepository ordersRepository;
    public List<Orders> getOrders(long id){
        return ordersRepository.findAllByUserId(id);
    }
    public Orders addOrders(Orders order){
        return ordersRepository.save(order);
    }
}
