package com.db.shopify.payments.service;


import com.db.shopify.payments.model.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value="remotePaymentService", url="localhost:8081/payments")
public interface ExternalPaymentInterface {
    @RequestMapping(method = RequestMethod.POST, value = "/validation")
    Payment checkPayment(Payment payment);
}
