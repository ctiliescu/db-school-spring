package com.db.shopify.authentification;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;

@RestController
public class AuthController {

    @PostMapping("/login")
    public void login(@RequestBody Auth auth){
        Cookie cookie =  new Cookie("username",auth.getUsername());
    }

}
