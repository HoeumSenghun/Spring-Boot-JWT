package com.example.jwtdemo.security;

import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final InMemoryUserDetailsManager manager;

    public CustomUserDetailsService(PasswordEncoder encoder) {
        UserDetails user = User.builder()
                .username("senghun")
                .password(encoder.encode("password123"))
                .roles("USER")
                .build();
        this.manager = new InMemoryUserDetailsManager(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        return manager.loadUserByUsername(username);
    }
}