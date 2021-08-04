package com.db.shopify.customer;

import java.util.List;
import java.util.Optional;

public interface CustomerServiceContract {
    public Customer createCustomer(Customer customer);
    public Optional<Customer> getCustomer(int id);
    public Optional<Customer> getCustomerByUsername(String username);
    public List<Customer> getCustomersByName(String firstname,int pageNumber);
    public List<Customer> getCustomersSorted(String firstname);
}
