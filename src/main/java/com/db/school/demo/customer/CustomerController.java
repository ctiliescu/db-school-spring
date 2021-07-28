package com.db.school.demo.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerServiceContract customerService;

    @GetMapping
    public ResponseEntity<Customer> getCustomer(@RequestParam("id") int id){
        //return customerService.getCustomer(id).map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        Optional<Customer> customer = customerService.getCustomer(id);
        if (customer.isPresent()) {
            return new ResponseEntity<>(customer.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/search")
    public List<Customer> getCustomersByName(@RequestParam("firstname") String firstname,@RequestParam("pageNumber") int pageNumber){
        return customerService.getCustomersByName(firstname,pageNumber);
    }

    @GetMapping("/search/sort")
    public List<Customer> getCustomersSorted(@RequestParam("lastname") String lastname){
        return customerService.getCustomersSorted(lastname);
    }

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerService.createCustomer(customer);
    }
}

