package com.db.payment;

public class PaymentRefuseException extends Exception {
    public PaymentRefuseException() {
        super("Payment refused by the service");
    }


}
