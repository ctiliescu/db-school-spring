package com.db.shopify.Auth;

import com.db.shopify.customer.Customer;
import com.db.shopify.payments.service.PaymentServiceContract;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    PaymentServiceContract paymentServiceContract;

    public void authLogin(@RequestBody Customer customer){

    }

}
