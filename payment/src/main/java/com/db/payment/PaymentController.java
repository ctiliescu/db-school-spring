package com.db.payment;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RequestMapping("/payments")
@RestController
public class PaymentController {

    @PostMapping("validation")
    public ResponseEntity<Payment> checkPayment(@RequestBody Payment payment) {
        Random random = new Random();
        if (random.nextInt(10) >= 8) {
            return new ResponseEntity<Payment>(HttpStatus.NOT_FOUND);
        } else {
            payment.setId(random.nextInt(1000));
            return new ResponseEntity<Payment>(payment, HttpStatus.ACCEPTED);
        }
    }
}
