package com.db.shopify.order.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Order implements Cloneable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    @Column(name = "order_date")
    //@NotBlank(message = "Order date is mandatory")
    public Date orderDate;
    @Column(name = "shipped_date")
    public Date shippedDate;
    @Column(name = "status")
   // @NotBlank(message = "Status is mandatory")
    public String status;
    @Column(name = "comments")
    public String comments;
    @Column(name = "customer_id")
   // @NotBlank(message = "Customer id is mandatory")
    public Long customerId;

    @Override
    public Object clone()
            throws CloneNotSupportedException
    {
        return super.clone();
    }
}
