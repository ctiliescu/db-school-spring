package com.db.shopify.payments;


import com.db.shopify.payments.model.Payment;
import com.db.shopify.payments.service.PaymentServiceContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;


@RestController
@RequestMapping("/payments")
public class PaymentController {
    @Autowired
    private PaymentServiceContract paymentService;

    @GetMapping()
    public ResponseEntity<List<Payment>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(paymentService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Payment> getById(@PathVariable("id") int id) {
        return ResponseEntity.status(HttpStatus.OK).body(paymentService.findById(id));
    }

    @PostMapping()
    public ResponseEntity<Payment> insertPayment(@RequestBody Payment payment) throws URISyntaxException {
        return ResponseEntity.status(HttpStatus.CREATED).body(paymentService.insertPayment(payment));
    }

    @DeleteMapping()
    public ResponseEntity deletePayment(@RequestParam("id") int id) {
        return ResponseEntity.status(HttpStatus.OK).body(paymentService.deletePaymentById(id));
    }

    @PutMapping()
    public ResponseEntity<Payment> updatePayment(@RequestBody Payment payment) {
        return ResponseEntity.status(HttpStatus.OK).body(paymentService.updatePayment(payment));
    }
}
