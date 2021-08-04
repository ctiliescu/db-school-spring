package com.db.shopify.customer;

import com.db.shopify.authentification.Auth;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    public List<Customer> getAllByFirstName(String s);
    Page<Customer> getAllByFirstName(String lastName, Pageable pageable);
    @Query("SELECT c FROM Customer c WHERE c.lastName = ?1")
    List<Customer> getAllByFirstNameAndSort(String lastName, Sort sort);
    @Query("SELECT c FROM Customer c WHERE c.firstName = ?1")
    public List<Customer> giveMeCustomers(String s);
    @Query("SELECT c FROM Customer c WHERE c.username = ?1")
    public Auth getCustomerByUsername(String s);
}
