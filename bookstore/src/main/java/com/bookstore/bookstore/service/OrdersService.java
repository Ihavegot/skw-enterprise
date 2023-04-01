package com.bookstore.bookstore.service;

import com.bookstore.bookstore.model.Orders;
import com.bookstore.bookstore.repository.OrdersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrdersService {
    private final OrdersRepository ordersRepository;
    public Page<Orders> getAllUsersOrders(int offset, int size){
        return ordersRepository.findAll(PageRequest.of(offset, size));
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
