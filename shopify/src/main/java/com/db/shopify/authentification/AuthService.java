package com.db.shopify.authentification;

import com.db.shopify.customer.Customer;
import com.db.shopify.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public class AuthService {

    @Autowired
    private CustomerService customerService;
    public String verify(Auth auth){
        customerService.getCustomerByUsername(auth.getUsername());
        String randomString = UUID.randomUUID().toString();
        return randomString;
    }
}
