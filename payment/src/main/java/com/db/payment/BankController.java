package com.db.payment;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RequestMapping("/payments")
@RestController
public class BankController {

    @PostMapping("validation")
    @ApiOperation(value = "This endpoint is use to validate a payment")
    public Payment checkPayment(@RequestBody Payment payment) throws InterruptedException, PaymentRefuseException {
        System.out.println("soebody make a request here");
        Random random = new Random();
        if (random.nextInt(10) >= 5) {
            throw new PaymentRefuseException();
        } else {
            Thread.sleep(1000);
            payment.setId(random.nextInt(1000));
            return payment;
        }
    }
}
