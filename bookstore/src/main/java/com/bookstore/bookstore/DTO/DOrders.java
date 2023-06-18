package com.bookstore.bookstore.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class DOrders {
    private String city;
    private String postCode;
    private String address;
}
