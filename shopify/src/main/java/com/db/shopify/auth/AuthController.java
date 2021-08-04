package com.db.shopify.auth;

import com.db.shopify.customer.CustomerRepository;
import com.db.shopify.customer.CustomerServiceContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private AuthServiceContract authService;

    @Autowired
    private CustomerRepository customerRepository;

    public ResponseEntity<String> login(@RequestBody LoginData loginData){

        return new ResponseEntity<String>("Test", HttpStatus.OK);
    }
}
