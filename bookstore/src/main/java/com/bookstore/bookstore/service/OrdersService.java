package com.bookstore.bookstore.service;

import com.bookstore.bookstore.DTO.DOrders;
import com.bookstore.bookstore.model.Books;
import com.bookstore.bookstore.model.Customers;
import com.bookstore.bookstore.model.Orders;
import com.bookstore.bookstore.repository.CustomersRepository;
import com.bookstore.bookstore.repository.OrdersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class OrdersService {
    private final OrdersRepository ordersRepository;
    private final CustomersRepository customersRepository;
    private final BooksService booksService;
    public Page<Orders> getAllUsersOrders(Pageable pageable){
        return ordersRepository.findAll(pageable);
    }
    public Page<Orders> getSingleUserOrders(long uid, Pageable pageable){
        return ordersRepository.findAllByUid(uid, pageable);
    }
    public Orders addOrders(DOrders dOrder){
        Orders newOrder = new Orders();
        Optional<Customers> uid = customersRepository.findByUsername(SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName()
        );
        newOrder.setUid(uid.map(Customers::getId).orElse(0L));
        newOrder.setCity(dOrder.getCity());
        newOrder.setPostcode(dOrder.getPostCode());
        newOrder.setAddress(dOrder.getAddress());

        newOrder.setOrderdate(Calendar.getInstance().getTime());

        return ordersRepository.save(newOrder);
    }
    public void deleteOrders(long id){
        ordersRepository.deleteById(id);
    }
}
