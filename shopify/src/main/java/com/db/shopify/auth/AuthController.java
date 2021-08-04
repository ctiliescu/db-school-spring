package com.db.shopify.auth;

import com.db.shopify.customer.Customer;
import com.db.shopify.product.Product;
import com.db.shopify.product.ProductServiceContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("/auth")
public class AuthController {
//    private static final java.util.UUID UUID = ;
    @Autowired
    AuthServiceContract authServiceContract;
    Map<String,String> authUser=new Map<String, String>() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean containsKey(Object key) {
            return false;
        }

        @Override
        public boolean containsValue(Object value) {
            return false;
        }

        @Override
        public String get(Object key) {
            return null;
        }

        @Override
        public String put(String key, String value) {
            return null;
        }

        @Override
        public String remove(Object key) {
            return null;
        }

        @Override
        public void putAll(Map<? extends String, ? extends String> m) {

        }

        @Override
        public void clear() {

        }

        @Override
        public Set<String> keySet() {
            return null;
        }

        @Override
        public Collection<String> values() {
            return null;
        }

        @Override
        public Set<Entry<String, String>> entrySet() {
            return null;
        }
    };


    public ResponseEntity<String> login(String username, String password){
        UUID.randomUUID().toString();
        return ResponseEntity.status(HttpStatus.OK).body(authServiceContract.login(username,password));
    }
}
