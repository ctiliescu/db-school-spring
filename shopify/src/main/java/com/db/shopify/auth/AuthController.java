package com.db.shopify.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public void login(@RequestBody LoginObject loginObject, HttpServletResponse response) {
        int customerId = authService.validateCustomer(loginObject);
        if (customerId != -1) {
            String randomString = UUID.randomUUID().toString();
            randomString = randomString + toString(customerId);
            response.addCookie(new Cookie("auth_token", randomString));
        }
    }
}
