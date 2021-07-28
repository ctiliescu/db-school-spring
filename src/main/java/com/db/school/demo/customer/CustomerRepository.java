package com.db.school.demo.customer;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    public List<Customer> getAllByFirstName(String s);
    @Query("SELECT c FROM Customer c WHERE c.firstName = ?1")
    public List<Customer> giveMeCustomers(String s);
}
