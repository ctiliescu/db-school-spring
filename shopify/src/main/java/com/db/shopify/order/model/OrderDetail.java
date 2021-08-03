package com.db.shopify.order.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
//import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "orderdetails")
@Data
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class OrderDetail implements Cloneable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    @Column(name = "orderId")
    //@NotBlank(message = "Order id is mandatory")
    public Long orderId;
    @Column(name = "product_code")
   // @NotBlank(message = "Product code is mandatory")
    public String productCode;
    @Column(name = "quantity")
   // @NotBlank(message = "Quantity is mandatory")
    public int quantity;
    @Column(name = "priceEach")
    //@NotBlank(message = "Price each is mandatory")
    public double priceEach;

    @Override
    public Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }
}