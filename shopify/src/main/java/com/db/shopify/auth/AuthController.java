package com.db.shopify.auth;

import com.db.shopify.customer.Customer;
import com.db.shopify.customer.CustomerServiceContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.UUID;

@RestController
public class AuthController {

    @Autowired
    CustomerServiceContract customerService;

    HashMap<String, String> loginMap = new HashMap<String, String>();

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginForm loginForm, HttpServletResponse response) {
        Customer customer = customerService.getCustomerForLogin(loginForm.getUsername(), loginForm.getPassword());

        if (customer == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Username or password is wrong");
        } else {
            String token = UUID.randomUUID().toString();
            System.out.println(token);
            customer.setPassword(null);
            loginMap.put(token, loginForm.getUsername());
            response.addCookie(new Cookie("token", token));
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(token);
        }
    }

    @GetMapping("/login")
    public ResponseEntity<Customer> findCustomerByToken(@CookieValue String token) {
        if (loginMap.containsKey(token)) {
            String username = loginMap.get(token);
        } else {

        }
    }
}
