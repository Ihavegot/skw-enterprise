package com.bookstore.bookstore.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
public class ShoppingCarts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long uid;
    @Transient
    private Double totalPrice;
    @Transient
    private int itemsNumber;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<CartItems> cartItems;
}
