package com.db.shopify.payments.service;



import com.db.shopify.payments.model.Payment;

import java.net.URISyntaxException;
import java.util.List;

public interface PaymentServiceContract {
    List<Payment> findAll();
    Payment insertPayment(Payment payment);
    Payment deletePaymentById(int id);
    Payment updatePayment(Payment payment);
    Payment findById(int id);
}
