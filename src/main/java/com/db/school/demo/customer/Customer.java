package com.db.school.demo.customer;

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

    public Customer(int id, String username, String lastName, String firstName, String phone, String address, String city, String postalCode, String country) {
        this.id = id;
        this.username = username;
        this.lastName = lastName;
        this.firstName = firstName;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
    }

    public Customer() {

    }
}
