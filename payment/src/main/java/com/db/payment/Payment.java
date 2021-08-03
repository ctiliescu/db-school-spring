package com.db.payment;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
public class Payment {
    Integer id;
    @ApiModelProperty(value = "The unique id of the customer that execute the payment")
    Integer customerId;
    @ApiModelProperty(value = "The date")
    Date paymentDate;
    @ApiModelProperty(value = "The amount of the payment")
    double amount;
}
