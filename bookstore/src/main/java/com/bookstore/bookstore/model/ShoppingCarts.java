package com.bookstore.bookstore.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
public class ShoppingCarts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long uid;
    private Double totalPrice;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "shoppingCarts")
    private Set<CartItems> cartItems;
}
