package com.db.shopify.login;


import com.db.shopify.customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping("/login")
    public void getLogin( @RequestBody LoginForm loginForm , HttpServletResponse response){
         Customer customer =   authService.verifyLogin(loginForm);
         if(customer != null) {
             response.addCookie(new Cookie("UID", UID));
             return new ResponseEntity<Customer>(HttpStatus.OK, customer);
         }



        return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);

        // TODO RETURN
    }


}
