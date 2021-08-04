package com.db.shopify.payments.service;


import com.db.shopify.payments.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("prod")
public class PaymentServiceInternal implements PaymentServiceContract {

    @Autowired
    private PaymentRepository paymentRepository;

    public List<Payment> findAll() {
        return paymentRepository.findAll();
    }

    public Payment insertPayment(Payment payment) {
        System.out.println("Sum is under threshold");
        paymentRepository.save(payment);
        return payment;
    }

    @Override
    public Payment deletePaymentById(int id) {
        Payment byId = paymentRepository.getById(id);
        paymentRepository.deleteById(byId.getCustomerId());
        return byId;
    }

    public Payment updatePayment(Payment payment) {
        Payment oldPayment = paymentRepository.getById(payment.getCustomerId());
        paymentRepository.save(payment);
        return oldPayment;
    }

    @Override
    public Payment findById(int id) {
        return paymentRepository.getById(id);
    }
}


