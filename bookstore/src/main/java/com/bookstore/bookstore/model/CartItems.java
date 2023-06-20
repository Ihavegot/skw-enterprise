package com.bookstore.bookstore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class CartItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private long id;
    private int quantity;
    @ManyToOne(fetch = FetchType.EAGER)
    private Books books;
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    private Orders orders;
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    private ShoppingCarts shoppingCarts;
    public CartItems() {}
}
