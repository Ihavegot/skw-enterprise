package com.bookstore.bookstore.model;

import jakarta.persistence.*;
import jakarta.persistence.criteria.Order;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long uid;
    private Date orderdate;
    private String city;
    private String postcode;
    private String address;
    private Double totalPrice;
    private String status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orders")
    private Set<CartItems> cartItems;
}
