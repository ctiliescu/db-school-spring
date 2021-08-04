package com.db.shopify.auth;

import com.db.shopify.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AuthService implements AuthServiceContract{

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public String verifyCustomer(LoginData loginData) {
        if( customerRepository.getCustomerByUsername(loginData.getUsername()) == null){
            return "Customer not found";
        }
        else if (!customerRepository.getCustomerByUsername(loginData.getUsername()).getPassword().equals(loginData.getPassword())){
            return "Password is not correct";
        }
        else {
            return UUID.randomUUID().toString();
        }
    }
}
