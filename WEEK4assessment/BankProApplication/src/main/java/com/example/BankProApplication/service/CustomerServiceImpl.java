package com.example.BankProApplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.BankProApplication.domain.Customer;
import com.example.BankProApplication.dto.*;
import java.util.List;
import java.util.stream.Collectors;

import com.example.BankProApplication.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer createCustomer(Customer customer){
        customerRepository.save(customer);
        return customer;
    }
    @Override
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElse(null);

    }
    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll().stream()
                .collect(Collectors.toList());
    }
    @Override
    public Customer updateCustomer(Customer customer) {
        if (customerRepository.existsById(customer.getId())) {
            customerRepository.save(customer);
        }
        return customerRepository.findById(customer.getId()).orElse(null);
    }
    @Override
    public String deleteCustomer(Long id) {
        if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
            return "Customer with ID " + id + " deleted successfully.";
        }
        return "Customer with ID " + id + " does not exist.";
    }
    
    
}
