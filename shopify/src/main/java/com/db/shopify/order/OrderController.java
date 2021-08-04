package com.db.shopify.order;


import com.db.shopify.order.model.Order;
import com.db.shopify.order.model.OrderDetail;
import com.db.shopify.order.model.OrderWithDetailsForm;
import com.db.shopify.order.service.OrderDetailServiceContract;
import com.db.shopify.order.service.OrderServiceContract;
import com.db.shopify.payments.model.Payment;
import com.db.shopify.payments.service.PaymentServiceContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderServiceContract orderService;

    @Autowired
    OrderDetailServiceContract orderDetailService;

    @Autowired
    PaymentServiceContract paymentService;


    @GetMapping
    public ResponseEntity<List<Order>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(orderService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getById(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(orderService.getById(id));
    }

    @PutMapping
    public ResponseEntity<Order> updateOrder(@RequestBody Order order) throws IllegalAccessException, CloneNotSupportedException {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.updateOrder(order));
    }

    @DeleteMapping
    public ResponseEntity<Order> deleteOrder(@RequestParam("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(orderService.deleteOrderById(id));
    }

    @PostMapping("/orderWithDetails")
    public ResponseEntity<OrderWithDetailsForm> insertOrderWithDetails(@RequestBody OrderWithDetailsForm orderWithDetailsForm) throws IllegalAccessException, CloneNotSupportedException, URISyntaxException {
        Order order = orderWithDetailsForm.getOrder();
        List<OrderDetail> orderDetailList = orderWithDetailsForm.getOrderDetailList();
        List<OrderDetail> orderDetailNewList = new ArrayList<>();
        int totalAmount = 0;
        for (OrderDetail orderDetail : orderDetailList) {
            OrderDetail od = orderDetailService.insertOrderDetail(orderDetail);
            if (od != null) {
                orderDetailNewList.add(od);
                totalAmount += od.getQuantity() * od.getPriceEach();
            }
        }
        if (orderDetailNewList.isEmpty()) {
            //return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order details are invalid");
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            Payment payment = new Payment();
            payment.setCustomerId(order.getCustomerId().intValue());
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            Date date = new Date();
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            payment.setPaymentDate(sqlDate);
            payment.setAmount(totalAmount);
            paymentService.insertPayment(payment);
            orderWithDetailsForm.setOrder(orderService.insertOrder(order));
            orderWithDetailsForm.setOrderDetailList(orderDetailNewList);
            return ResponseEntity.status(HttpStatus.OK).body(orderWithDetailsForm);
        }
    }
}
