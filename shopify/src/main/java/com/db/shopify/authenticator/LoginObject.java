package com.db.shopify.authenticator;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class LoginObject {
    private String userName;
    private String password;
}
