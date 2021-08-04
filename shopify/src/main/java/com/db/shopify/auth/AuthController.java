package com.db.shopify.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.UUID;


@RestController
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping("/login")
    public String login(@RequestBody LoginData loginData){
        String rand= null;
        if(loginData.getPassword == authService.customerService.getCustomerByUsername(loginData.getUsername).getPassword){
            return rand;
        }else{
            throw new Exception;
        }
    }

}
