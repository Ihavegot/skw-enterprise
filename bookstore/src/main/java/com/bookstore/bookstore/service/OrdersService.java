package com.bookstore.bookstore.service;

import com.bookstore.bookstore.DTO.DOrders;
import com.bookstore.bookstore.model.Books;
import com.bookstore.bookstore.model.Orders;
import com.bookstore.bookstore.repository.OrdersRepository;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrdersService {
    private final OrdersRepository ordersRepository;
    private final BooksService booksService;
    public Page<Orders> getAllUsersOrders(Pageable pageable){
        return ordersRepository.findAll(pageable);
    }
    public Page<Orders> getSingleUserOrders(long uid, Pageable pageable){
        return ordersRepository.findAllByUid(uid, pageable);
    }
    public Orders addOrders(DOrders dOrder){
        Orders newOrder = new Orders();
        newOrder.setUid(dOrder.getUid());
        newOrder.setCity(dOrder.getCity());
        newOrder.setPostcode(dOrder.getPostCode());
        newOrder.setAddress(dOrder.getAddress());

        List<Books> orderedBooks = new ArrayList<>();
        for(Long bid: dOrder.getBooks()){
            orderedBooks.add(booksService.getSingleBook(bid));
        }
        newOrder.setBooks(orderedBooks);
        newOrder.setOrderdate(Calendar.getInstance().getTime());

        return ordersRepository.save(newOrder);
    }
    public void deleteOrders(long id){
        ordersRepository.deleteById(id);
    }
}
