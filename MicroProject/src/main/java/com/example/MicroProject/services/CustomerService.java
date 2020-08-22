package com.example.MicroProject.services;

import com.example.MicroProject.web.model.Customer;

import java.util.UUID;

public interface CustomerService {
    Customer getCustomerById(int id);
}
