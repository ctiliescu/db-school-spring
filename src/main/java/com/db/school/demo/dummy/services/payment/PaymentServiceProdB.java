package com.db.school.demo.dummy.services.payment;

public class PaymentServiceProdB implements PaymentService{
    public String payConfirm() {
        return "Your payment has been confirmed by service B running on production";
    }
}
