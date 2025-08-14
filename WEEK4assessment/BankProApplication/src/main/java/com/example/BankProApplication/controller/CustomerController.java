package com.example.BankProApplication.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.BankProApplication.service.CustomerService;
import com.example.BankProApplication.domain.Customer;
import com.example.BankProApplication.dto.CustomerResponseDTO;
import com.example.BankProApplication.mapper.CustomerMapper;
@RestController
@RequestMapping("/customers")
public class CustomerController {
    
    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerMapper customerMapper;

    @GetMapping
    public List<CustomerResponseDTO> getAllCustomers(){
        List<CustomerResponseDTO> list = new ArrayList<>();
        for (Customer customer: customerService.getAllCustomers()) {
            list.add(customerMapper.toResponse(customer));
        }
        return list;
    }

    @GetMapping("/{id}")
    public CustomerResponseDTO getCustomerById(Long id) {
        Customer customer = customerService.getCustomerById(id);
        if (customer != null) {
            return customerMapper.toResponse(customer);
        }
        return null; 
    }
    @PostMapping("/admin")
    public CustomerResponseDTO createCustomer(@RequestBody Customer customer) {
        Customer createdCustomer = customerService.createCustomer(customer);
        return customerMapper.toResponse(createdCustomer);
    }
    @PutMapping("/admin/{id}")
    public CustomerResponseDTO updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        Customer updatedCustomer = customerService.updateCustomer(customer);
        if (updatedCustomer != null) {
            return customerMapper.toResponse(updatedCustomer);
        }
        return null; 
    }
    @DeleteMapping("/admin/{id}")
    public String deleteCustomer(@PathVariable Long id) {
        return customerService.deleteCustomer(id);
    }

}
