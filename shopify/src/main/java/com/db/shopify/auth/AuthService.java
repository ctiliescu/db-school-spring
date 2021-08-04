package com.db.shopify.auth;

import com.db.shopify.customer.Customer;
import com.db.shopify.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;

import java.util.HashMap;

@Service
public class AuthService {
    HashMap<Integer, String> map = new HashMap<>();

    @Autowired
    CustomerRepository customerRepository;

    public boolean validateLogin(LoginData loginData) {
        Customer customer = customerRepository.getByUsername(loginData.getUsername());
        if (customer == null) {
            return false;
        }
        if (!customer.getPassword().equals(loginData.getPassword())) {
            return false;
        }

        String uuid = UUID.randomUUID().toString();
        map.put(customer.getId(), uuid);
        // return cookie

        return true;
    }



}
