package com.db.shopify.payments;


import com.db.shopify.payments.model.Payment;
import com.db.shopify.payments.service.PaymentServiceContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/payments")
public class PaymentController {
    @Autowired
    private PaymentServiceFactory paymentService;

    @GetMapping()
    public ResponseEntity<List<Payment>> findAll() {
        PaymentServiceContract paymentServiceTemp = paymentService.getService(1);
        return ResponseEntity.status(HttpStatus.OK).body(paymentServiceTemp.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Payment> getById(@PathVariable("id") int id) {
        PaymentServiceContract paymentServiceTemp = paymentService.getService(1);
        return ResponseEntity.status(HttpStatus.OK).body(paymentServiceTemp.findById(id));
    }

    @PostMapping()
    public ResponseEntity<Payment> insertPayment(@RequestBody Payment payment) {
        PaymentServiceContract paymentServiceTemp = paymentService.getService(payment.getAmount());
        return ResponseEntity.status(HttpStatus.CREATED).body(paymentServiceTemp.insertPayment(payment));
    }

    @DeleteMapping()
    public ResponseEntity deletePayment(@RequestParam("id") int id) {
        PaymentServiceContract paymentServiceTemp = paymentService.getService(1);
        return ResponseEntity.status(HttpStatus.OK).body(paymentServiceTemp.deletePaymentById(id));
    }

    @PutMapping()
    public ResponseEntity<Payment> updatePayment(@RequestBody Payment payment) {
        PaymentServiceContract paymentServiceTemp = paymentService.getService(1);
        return ResponseEntity.status(HttpStatus.OK).body(paymentServiceTemp.updatePayment(payment));
    }
}
