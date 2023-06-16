package com.bookstore.bookstore.DTO;

import com.bookstore.bookstore.model.Books;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class DBaskets {
    private List<Long> books;
}
