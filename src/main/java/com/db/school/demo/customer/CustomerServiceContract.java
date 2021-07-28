package com.db.school.demo.customer;

import java.util.List;
import java.util.Optional;

public interface CustomerServiceContract {
    public Customer createCustomer(Customer customer);
    public Optional<Customer> getCustomer(int id);
    public List<Customer> getCustomersByName(String firstname);
}
