package com.example.MicroProject.services;

import com.example.MicroProject.web.model.BeerDto;
import com.example.MicroProject.web.model.Customer;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Override
    public Customer getCustomerById(int id) {
        return Customer.builder().id(1)
                .name("Theodians")
                .build();
    }
}
