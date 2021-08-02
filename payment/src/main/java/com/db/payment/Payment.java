package com.db.payment;


import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Date;

@Data
@NoArgsConstructor
public class Payment {
    Integer id;
    Integer customerId;
    Date paymentDate;
    double amount;
}
