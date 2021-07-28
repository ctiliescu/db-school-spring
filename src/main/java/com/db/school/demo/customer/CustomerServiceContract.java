package com.db.school.demo.customer;

import java.util.Optional;

public interface CustomerServiceContract {
    public Customer createCustomer(Customer customer);
    public Optional<Customer> getCustomer(int id);
}
