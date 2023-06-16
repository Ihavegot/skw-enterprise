package com.bookstore.bookstore.mappers;

import com.bookstore.bookstore.DTO.DUserDetails;
import com.bookstore.bookstore.model.Customers;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;
import java.util.List;

@Mapper
public interface MUserDetails {
    @Mapping(target = "username", source = "username")
    @Mapping(target = "enabled", ignore = true)
    @Mapping(target = "credentialsNonExpired", ignore = true)
    @Mapping(target = "accountNonLocked", ignore = true)
    @Mapping(target = "accountNonExpired", ignore = true)
    DUserDetails map(Customers customers);
    default List<SimpleGrantedAuthority> map(String role) {
        if (role == null)
            role = "ROLE_USER";
        return Collections.singletonList(new SimpleGrantedAuthority(role));
    }
}
