package com.db.school.demo.dummy.services.payment;

public class PaymentServiceProdA implements PaymentService{
    public String payConfirm() {
        return "Your payment has been confirmed by service A running on production";
    }
}
