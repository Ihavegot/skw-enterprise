package com.bookstore.bookstore.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DCustomer {
    private String username;
    private String password;
    private String email;
}
