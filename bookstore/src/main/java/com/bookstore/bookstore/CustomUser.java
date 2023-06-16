package com.bookstore.bookstore;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Getter
public class CustomUser extends User {
    private final long uid;

    public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities, long uid) {
        super(username, password, authorities);
        this.uid=uid;
    }
}
