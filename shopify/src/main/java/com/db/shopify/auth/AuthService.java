package com.db.shopify.auth;

import com.db.shopify.auth.model.AuthException;
import com.db.shopify.customer.CustomerServiceContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class AuthService {
    private Map<String, Integer> authCache = new HashMap<>();

    @Autowired
    private CustomerServiceContract customerService;

    public String generateToken(LoginData loginData) throws AuthException {
        return customerService.getCustomerByUsername(loginData.getUsername())
                .filter(u -> u.getPassword().equals(loginData.getPassword()))
                .map(e -> {
                    String uuid = UUID.randomUUID().toString();
                    authCache.put(uuid, e.getId());
                    return uuid;
                })
                .orElseThrow(AuthException::new);
    }

    public int getAuthClient(String authToken) throws AuthException {
        if (authCache.containsKey(authToken)) {
            return authCache.get(authToken);
        } else {
            throw new AuthException();
        }
    }
}
