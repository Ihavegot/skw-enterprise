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
    public List<Orders> getAllUsersOrders(){
        return ordersRepository.findAll();
    }
    public List<Orders> getSingleUserOrders(long uid){
        return ordersRepository.findAllByUid(uid);
    }
    public Orders addOrders(Orders order){
        return ordersRepository.save(order);
    }
    public void deleteOrders(long id){
        ordersRepository.deleteById(id);
    }
}
