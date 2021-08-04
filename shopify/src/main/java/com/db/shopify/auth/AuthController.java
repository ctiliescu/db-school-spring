package com.db.shopify.auth;

import com.db.shopify.customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.UUID;

@RestController
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity authCustomer(@RequestBody LoginForm loginForm) {
        Optional<Customer> customerOp = authService.authCustomer(loginForm);
        if (customerOp.isPresent()) {
            String uniqueCode = UUID.randomUUID().toString();
            authService.identityMap.put(customerOp.get(), uniqueCode);
            return new ResponseEntity(HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
