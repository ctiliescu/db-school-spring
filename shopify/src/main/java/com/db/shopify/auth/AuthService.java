package com.db.shopify.auth;

import com.db.shopify.customer.Customer;
import com.db.shopify.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private CustomerService customerService;

    public int validateCustomer(LoginObject loginObject) {
        Customer customer = customerService.getCustomersByUsername(loginObject.getUsername());
        if (customer == null) {
            return -1;
        } else {
           if (customer.getPassword().equals(loginObject.getPassword())) {
               return customer.getId();
           }
        }
        return 0;
    }
}
