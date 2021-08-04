package com.db.shopify.authenticator;

import com.db.shopify.customer.Customer;
import com.db.shopify.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;

public class AuthService implements AuthServiceContract {

    @Autowired
    CustomerService customerService;

    public String login(LoginObject loginObject) {
        Customer[] customers = customerService.getAll();
        return null;
    }
}
