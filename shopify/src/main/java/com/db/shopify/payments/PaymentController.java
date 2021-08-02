package com.db.shopify.payments;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentServiceFactory paymentService;

    @GetMapping("/all")
    public ResponseEntity findAll() {
        PaymentServiceContract paymentServiceTemp = paymentService.getService(1);
        return ResponseEntity.status(HttpStatus.OK).body(paymentServiceTemp.findAll());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity getById(@PathVariable("id") int id) {
        PaymentServiceContract paymentServiceTemp = paymentService.getService(1);
        return ResponseEntity.status(HttpStatus.OK).body(paymentServiceTemp.findById(id));
    }

    @PostMapping("/insert")
    public ResponseEntity insertPayment(@RequestBody Payment payment) {
        PaymentServiceContract paymentServiceTemp = paymentService.getService(1);
        return ResponseEntity.status(HttpStatus.CREATED).body(paymentServiceTemp.insertPayment(payment));
    }

    @DeleteMapping("/delete")
    public ResponseEntity deletePayment(@RequestParam("id") int id) {
        PaymentServiceContract paymentServiceTemp = paymentService.getService(1);
        return ResponseEntity.status(HttpStatus.OK).body(paymentServiceTemp.deletePaymentById(id));
    }

    @PutMapping("/update")
    public ResponseEntity updatePayment(@RequestBody Payment payment) {
        PaymentServiceContract paymentServiceTemp = paymentService.getService(1);
        return ResponseEntity.status(HttpStatus.OK).body(paymentServiceTemp.updatePayment(payment));
    }


}
