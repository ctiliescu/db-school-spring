package com.db.shopify.payments;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PaymentServiceFactory {

    private PaymentServiceContract service;

    @Value("${spring.profiles.active}")
    private String profile;

    @Bean
    public PaymentServiceContract cardService() {
        service = new PaymentServiceCard();
        return service;
    }

    @Bean
    public PaymentServiceContract depositService() {
        service = new PaymentServiceDeposit();
        return service;
    }

    @Bean
    public PaymentServiceContract devService() {
        service = new PaymentServiceDev();
        return service;
    }

    public PaymentServiceContract getService(double amount) {
        System.out.println(profile);
        if (profile.equals("dev")) {
            return devService();
        }
        if (amount > 200) {
            return depositService();
        } else {
            return cardService();
        }
    }

    @Bean
    public PaymentServiceContract accessService() {
        return service;
    }
}




