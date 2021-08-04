package com.db.shopify.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements CustomerServiceContract {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer createCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    public Optional<Customer> getCustomer(int id){
        return customerRepository.findById(id);
    }

    public Customer getCustomerByUsername(String username){
        return customerRepository.getCustomerByUsername(username);
    }

    @Override
    public List<Customer> getCustomersByName(String firstname, int pageNumber) {
        Pageable pageRequest = PageRequest.of(pageNumber, 2);
        return customerRepository.getAllByFirstName(firstname,pageRequest).toList();
    }
    public List<Customer> getCustomersSorted(String firstname) {
        return customerRepository.getAllByFirstNameAndSort(firstname,Sort.by("id").descending());
    }


}
