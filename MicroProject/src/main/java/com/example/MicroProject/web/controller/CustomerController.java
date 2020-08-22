package com.example.MicroProject.web.controller;

import com.example.MicroProject.services.BeerService;
import com.example.MicroProject.services.CustomerService;
import com.example.MicroProject.web.model.BeerDto;
import com.example.MicroProject.web.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequestMapping("api/v1/customer")
@RestController
public class CustomerController {
    private final CustomerService customerService;


    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping({"/{CustomerId}"})
    public ResponseEntity<Customer> getCustomer(@PathVariable("CustomerId") int id){
        return new ResponseEntity<>(customerService.getCustomerById(id), HttpStatus.OK);
    }
}
