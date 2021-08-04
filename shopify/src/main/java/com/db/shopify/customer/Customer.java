package com.db.shopify.customer;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="customers")
@Data
public class Customer {
    @Id
    private int id;
    private String username;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "first_name")
    private String firstName;
    private String phone;
    private String address;
    private String city;
    private String postalCode;
    private String country;
    private String password;

    public Customer() {

    }
}
