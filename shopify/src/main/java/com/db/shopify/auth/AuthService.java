package com.db.shopify.auth;

import com.db.shopify.customer.CustomerService;
import com.db.shopify.customer.CustomerServiceContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    CustomerServiceContract customerService;

}
