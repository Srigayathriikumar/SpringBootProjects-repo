package com.example.EcommerceApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import com.example.EcommerceApplication.domain.*;
import com.example.EcommerceApplication.repository.*;
import java.util.Date;

@SpringBootApplication
public class EcommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}

	@Bean
	CommandLineRunner loadData(UserRepository userRepository, ProductRepository productRepository, 
							   OrderRepository orderRepository, OrderItemRepository orderItemRepository) {
		return args -> {

			User user1 = new User(null, "john_doe", "john@example.com", "USER", "password123");
			User user2 = new User(null, "jane_smith", "jane@example.com", "ADMIN", "admin123");
			User user3 = new User(null, "bob_wilson", "bob@example.com", "USER", "password456");
			User user4 = new User(null, "alice_brown", "alice@example.com", "USER", "password789");
			User user5 = new User(null, "mike_davis", "mike@example.com", "ADMIN", "admin456");
			userRepository.save(user1);
			userRepository.save(user2);
			userRepository.save(user3);
			userRepository.save(user4);
			userRepository.save(user5);

			Product product1 = new Product(null, "Laptop", "Gaming laptop", 999.99, "Electronics", 10);
			Product product2 = new Product(null, "Phone", "Smartphone", 599.99, "Electronics", 25);
			Product product3 = new Product(null, "Tablet", "10-inch tablet", 299.99, "Electronics", 15);
			Product product4 = new Product(null, "Headphones", "Wireless headphones", 149.99, "Electronics", 30);
			Product product5 = new Product(null, "Mouse", "Gaming mouse", 49.99, "Electronics", 50);
			productRepository.save(product1);
			productRepository.save(product2);
			productRepository.save(product3);
			productRepository.save(product4);
			productRepository.save(product5);

		
			Order order1 = new Order(null, new Date(), user1, "PENDING");
			Order order2 = new Order(null, new Date(), user2, "COMPLETED");
			Order order3 = new Order(null, new Date(), user3, "SHIPPED");
			Order order4 = new Order(null, new Date(), user4, "PENDING");
			Order order5 = new Order(null, new Date(), user5, "COMPLETED");
			orderRepository.save(order1);
			orderRepository.save(order2);
			orderRepository.save(order3);
			orderRepository.save(order4);
			orderRepository.save(order5);

			
			OrderItem orderItem1 = new OrderItem(null, order1, product1, 1);
			OrderItem orderItem2 = new OrderItem(null, order2, product2, 2);
			OrderItem orderItem3 = new OrderItem(null, order3, product3, 1);
			OrderItem orderItem4 = new OrderItem(null, order4, product4, 3);
			OrderItem orderItem5 = new OrderItem(null, order5, product5, 2);
			orderItemRepository.save(orderItem1);
			orderItemRepository.save(orderItem2);
			orderItemRepository.save(orderItem3);
			orderItemRepository.save(orderItem4);
			orderItemRepository.save(orderItem5);
		};
	}

}
