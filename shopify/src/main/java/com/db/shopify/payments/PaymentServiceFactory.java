package com.db.shopify.payments;


import com.db.shopify.payments.service.PaymentServiceContract;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PaymentServiceFactory {

    @Value("${service.payment}")
    private String paymentForHighValue;

    @Autowired
    public List<PaymentServiceContract> paymentServiceContractList;

    public PaymentServiceContract getService(double amount) {
        if (paymentServiceContractList.size() == 1) {
            return paymentServiceContractList.get(0);
        } else {
            if (amount > 200) {
                return paymentServiceContractList.stream().filter(p -> p.getClass().getSimpleName().equals(paymentForHighValue)).findFirst().get();
            } else {
                return paymentServiceContractList.stream().filter(p -> !p.getClass().getSimpleName().equals(paymentForHighValue)).findFirst().get();
            }
        }
    }
}




