package com.db.shopify.payments.service;

import com.db.shopify.payments.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;
import java.nio.charset.StandardCharsets;
import java.util.List;


@Service
@Profile("prod")
@Primary
public class PaymentServiceExternal implements PaymentServiceContract {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private HttpPaymentService externalPaymentInterface;

    public List<Payment> findAll() {
        return paymentRepository.findAll();
    }

    public Payment findById(int id) {
        return paymentRepository.getById(id);
    }

    public Payment insertPayment(Payment payment) throws URISyntaxException {

        try{
            Payment paymentResponse = externalPaymentInterface.httpValidationFunction(payment);
            System.out.println(paymentResponse);
            paymentRepository.save(payment);
        } catch (Exception e) {
            System.out.println("ERROR");
        }

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


