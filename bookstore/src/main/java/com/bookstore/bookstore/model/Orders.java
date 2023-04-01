package com.bookstore.bookstore.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    // TODO: change this!!!
    @OneToMany(targetEntity = Books.class)
    private List<Books> books = new ArrayList<>();
}
