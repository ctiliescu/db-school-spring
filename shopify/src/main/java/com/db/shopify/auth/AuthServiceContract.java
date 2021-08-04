package com.db.shopify.auth;


public interface AuthServiceContract {
    String verifyCustomer(LoginData loginData);
}
