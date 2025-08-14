package com.example.BankProApplication.repository;
import com.example.BankProApplication.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CustomerRepository extends JpaRepository<Customer,Long>{

} 