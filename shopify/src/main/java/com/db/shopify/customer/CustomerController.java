package com.db.shopify.customer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private Logger logger = LoggerFactory.getLogger(CustomerController.class);



    @Autowired
    private CustomerServiceContract customerService;

    @GetMapping
    public ResponseEntity<Customer> getCustomer(@RequestParam("id") int id){
        //return customerService.getCustomer(id).map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        Optional<Customer> customer = customerService.getCustomer(id);
        logger.info("WE have a getCustomer method invoked forId:" + id);
        if (customer.isPresent()) {
            return new ResponseEntity<>(customer.get(), HttpStatus.OK);
        } else {
            logger.warn("getCustomer hasn't found any Customers with id: "+ id);
//            try{
//                customer.get();
//            }catch (Exception e){
//                logger.error("Generated error in getCustomer with id", e);
//                logger.error("Generated error in getCustomer with id");
//        }
          //  customer.get();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }


    @GetMapping("/search")
    public List<Customer> getCustomersByName(@RequestParam("firstname") String firstname,@RequestParam("pageNumber") int pageNumber){
        return customerService.getCustomersByName(firstname,pageNumber);
    }

    @GetMapping("/auth")
    public Customer getCustomersByName(@CookieValue(name = "userId") int id){
        return customerService.getCustomer(id).get();
    }

    @GetMapping("/search/sort")
    public List<Customer> getCustomersSorted(@RequestParam("lastname") String lastname){
        return customerService.getCustomersSorted(lastname);
    }

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer, HttpServletResponse response) {
        final Customer newCustomer = customerService.createCustomer(customer);
        response.addCookie(new Cookie("userId", Integer.toString(newCustomer.getId())));
        return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
    }

}

