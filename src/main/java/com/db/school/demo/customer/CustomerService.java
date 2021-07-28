package com.db.school.demo.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService implements CustomerServiceContract {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer createCustomer(Customer customer){
        System.out.println(customer);
        return customer;
    }

    public Optional<Customer> getCustomer(int id){
        return customerRepository.findById(id);
    }

}
