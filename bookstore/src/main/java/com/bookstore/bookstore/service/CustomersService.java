package com.bookstore.bookstore.service;

import com.bookstore.bookstore.DTO.DBooks;
import com.bookstore.bookstore.DTO.DCustomer;
import com.bookstore.bookstore.model.Books;
import com.bookstore.bookstore.model.Customers;
import com.bookstore.bookstore.repository.CustomersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CustomersService {
    private final CustomersRepository customersRepository;
    public Optional<Customers> getSingleCustomer(long id){
        return customersRepository.findById(id);
    }
    public Optional<Customers> findByUsername(String username){
        return customersRepository.findByUsername(username);
    }
    public Customers addCustomer(DCustomer dCustomer){
        Customers newCustomer = new Customers();
        newCustomer.setAuthorities("ROLE_USER");
        newCustomer.setUsername(dCustomer.getUsername());
        newCustomer.setPassword(dCustomer.getPassword());
        newCustomer.setEmail(dCustomer.getEmail());
        return customersRepository.save(newCustomer);
    }
    public void deleteCustomer(long id){
        customersRepository.deleteById(id);
    }
    public Optional<Customers> updateCustomer(Long id, DCustomer dCustomer){
        return customersRepository.findById(id).map(c -> {
            if (dCustomer.getUsername() != null) {
                c.setUsername(dCustomer.getUsername());
            }
            if(dCustomer.getPassword() != null){
                c.setPassword(dCustomer.getPassword());
            }
            if(dCustomer.getEmail()!= null){
                c.setEmail(dCustomer.getEmail());
            }
            return customersRepository.save(c);
        });
    }
}
