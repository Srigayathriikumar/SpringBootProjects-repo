package com.example.BankProApplication.service;
import com.example.BankProApplication.domain.Customer;
import com.example.BankProApplication.dto.CustomerRequestDTO;
import com.example.BankProApplication.dto.CustomerResponseDTO;

import java.util.List;
public interface CustomerService {
    public CustomerRequestDTO createCustomer(CustomerRequestDTO customer);
    public Customer getCustomerById(Long id);
    public List<Customer> getAllCustomers();
    public Customer updateCustomer(Customer customer);
    public String deleteCustomer(Long id);
}
