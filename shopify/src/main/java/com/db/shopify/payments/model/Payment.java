package com.db.shopify.payments.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "payments")
@Data
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    @Column(name = "customer_id")
    Integer customerId;

    @Column(name = "payment_date")
    Date paymentDate;
    @Column(name = "amount", precision = 2)
    double amount;

    public Integer getCustomerId() {
        return customerId;
    }
}
