package com.db.shopify.auth;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoginObject {
    private String username;
    private String password;
}
