package com.db.shopify.auth;

import com.db.shopify.customer.Customer;
import com.db.shopify.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private CustomerService customerService;

    HashMap<Customer, String> identityMap;

    public Optional<Customer> authCustomer(LoginForm loginForm) {
        return customerService.authCustomer(loginForm.getUsername(), loginForm.getPassword());
    }
}
