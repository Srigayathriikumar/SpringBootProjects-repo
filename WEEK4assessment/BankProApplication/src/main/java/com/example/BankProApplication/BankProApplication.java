package com.example.BankProApplication;
import com.example.BankProApplication.domain.Account;
import com.example.BankProApplication.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.example.BankProApplication.domain.*;
import java.util.Date;

@SpringBootApplication
public class BankProApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankProApplication.class, args);
	}
@Bean
    public CommandLineRunner loadData(CustomerRepository customerRepository, AccountRepository accountRepository, TransactionRepository transactionRepository) {
		return (args) -> {
			
			Customer c1 = new Customer(null, "John Doe", "john@email.com", "1234567890");
			Customer c2 = new Customer(null, "Jane Smith", "jane@email.com", "0987654321");
			Customer c3 = new Customer(null, "Bob Johnson", "bob@email.com", "1122334455");
			Customer c4 = new Customer(null, "Alice Brown", "alice@email.com", "5566778899");
			Customer c5 = new Customer(null, "Charlie Wilson", "charlie@email.com", "9988776655");
			customerRepository.save(c1);
			customerRepository.save(c2);
			customerRepository.save(c3);
			customerRepository.save(c4);
			customerRepository.save(c5);

			Account a1 = new Account(null, "ACC001", "Savings", 1000.0, c1);
			Account a2 = new Account(null, "ACC002", "Current", 2000.0, c2);
			Account a3 = new Account(null, "ACC003", "Savings", 1500.0, c3);
			Account a4 = new Account(null, "ACC004", "Current", 3000.0, c4);
			Account a5 = new Account(null, "ACC005", "Savings", 2500.0, c5);
			accountRepository.save(a1);
			accountRepository.save(a2);
			accountRepository.save(a3);
			accountRepository.save(a4);
			accountRepository.save(a5);

			Transaction t1 = new Transaction(null, new Date(), 100.0, "Credit", a1);
			Transaction t2 = new Transaction(null, new Date(), 200.0, "Debit", a2);
			Transaction t3 = new Transaction(null, new Date(), 150.0, "Credit", a2);
			Transaction t4 = new Transaction(null, new Date(), 300.0, "Debit", a4);
			Transaction t5 = new Transaction(null, new Date(), 250.0, "Credit", a5);
			transactionRepository.save(t1);
			transactionRepository.save(t2);
			transactionRepository.save(t3);
			transactionRepository.save(t4);
			transactionRepository.save(t5);
		};
	}
}