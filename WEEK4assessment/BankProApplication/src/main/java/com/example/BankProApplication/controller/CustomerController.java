package com.example.BankProApplication.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import jakarta.validation.Valid;
import com.example.BankProApplication.service.CustomerService;
import com.example.BankProApplication.domain.Customer;
import com.example.BankProApplication.dto.CustomerRequestDTO;
import com.example.BankProApplication.dto.CustomerResponseDTO;
import com.example.BankProApplication.mapper.CustomerMapper;
@RestController
@RequestMapping("/customers")
public class CustomerController {
    
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<CustomerResponseDTO> getAllCustomers(){
        List<CustomerResponseDTO> list = new ArrayList<>();
        for (Customer customer: customerService.getAllCustomers()) {
            list.add(CustomerMapper.toResponse(customer));
        }
        return list;
    }

    @GetMapping("/{id}")
    public CustomerResponseDTO getCustomerById(@PathVariable Long id) {
        Customer customer = customerService.getCustomerById(id);
        if (customer != null) {
            return CustomerMapper.toResponse(customer);
        }
        return null; 
    }
    @PostMapping("/admin")
    public CustomerRequestDTO createCustomer(@RequestBody @Valid CustomerRequestDTO customer) {
         customerService.createCustomer(customer);
        return customer;
    }
    @PutMapping("/admin/{id}")
    public CustomerResponseDTO updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        customer.setId(id);
        Customer updatedCustomer = customerService.updateCustomer(customer);
        if (updatedCustomer != null) {
            return CustomerMapper.toResponse(updatedCustomer);
        }
        return null; 
    }
    @DeleteMapping("/admin/{id}")
    public String deleteCustomer(@PathVariable Long id) {
        return customerService.deleteCustomer(id);
    }

}