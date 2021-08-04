package com.db.shopify.login;


import com.db.shopify.customer.Customer;
import com.db.shopify.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthService {

    @Autowired
    CustomerService customerService;



    public Customer verifyLogin(LoginForm loginForm) {
        List<Customer> customerList = customerService.findAll();
        Customer loggedCustomer = null;

        for (Customer customer : customerList) {
            if (customer.getUsername().equals(loginForm.getUsername()) &&
                    customer.getPassword().equals(loginForm.getPassword())) {
                loggedCustomer = customer;
            }

        }
        return loggedCustomer;
    }




}
