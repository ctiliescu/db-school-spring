package com.db.shopify.payments.service;

import com.db.shopify.payments.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;
import java.util.List;

import java.lang.Object;
import jdk.incubator.*;


@Service
@Profile("prod")
public class PaymentServiceExternal implements PaymentServiceContract {

    @Autowired
    private PaymentRepository paymentRepository;

    public List<Payment> findAll() {
        return paymentRepository.findAll();
    }

    public Payment findById(int id) {
        return paymentRepository.getById(id);
    }

    public Payment insertPayment(Payment payment) throws URISyntaxException {
        System.out.println("Amount is over threshold");
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("localhost:8081/payments/validation"))
                .build();

        paymentRepository.save(payment);
        return payment;
    }



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


}


