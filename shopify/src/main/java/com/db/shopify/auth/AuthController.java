package com.db.shopify.auth;

import com.db.shopify.auth.model.AuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public void login(@RequestBody LoginData loginData, HttpServletResponse response) throws AuthException {
        response.addCookie(new Cookie("token", authService.generateToken(loginData)));
    }
}
