package com.example.BankProApplication.mapper;

import org.springframework.stereotype.Component;
import com.example.BankProApplication.dto.CustomerRequestDTO;
import com.example.BankProApplication.dto.CustomerResponseDTO;
import com.example.BankProApplication.domain.Customer;
@Component
public class CustomerMapper {
    
    public static CustomerResponseDTO toResponse(Customer customer) {
        CustomerResponseDTO customerResponseDTO = new CustomerResponseDTO();
        customerResponseDTO.setId(customer.getId());
        customerResponseDTO.setName(customer.getName());
        customerResponseDTO.setEmail(customer.getEmail());
        customerResponseDTO.setPhoneNumber(customer.getPhoneNumber());
        return customerResponseDTO;
    }

    public static Customer toEntity(CustomerRequestDTO customerRequestDTO) {
        Customer customer = new Customer();
        customer.setId(customerRequestDTO.getId());
        customer.setName(customerRequestDTO.getName());
        customer.setEmail(customerRequestDTO.getEmail());
        customer.setPhoneNumber(customerRequestDTO.getPhoneNumber());
        return customer;
    }
}
