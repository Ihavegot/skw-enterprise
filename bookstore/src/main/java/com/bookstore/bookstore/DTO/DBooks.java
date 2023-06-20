package com.bookstore.bookstore.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class DBooks {
    private String title;
    private String author;
    private String genre;
    private double price;
}
