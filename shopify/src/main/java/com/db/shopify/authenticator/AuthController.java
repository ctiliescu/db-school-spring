package com.db.shopify.authenticator;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/authenticate")
@RestController
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping
    @ApiOperation(value = "This endpoint is use to authenticate")
    public void login(@RequestBody LoginObject loginObject) {
        authService.login(loginObject);
    }
}
