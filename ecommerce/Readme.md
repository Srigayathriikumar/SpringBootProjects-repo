# E-Commerce Console Application (Java)

## Introduction

This is a command-line based E-Commerce Application developed in Java. It simulates an online shopping experience, allowing users to enter their details, browse products, add items to a cart, and complete the checkout process.

The application follows **Object-Oriented Programming (OOP)** principles and makes use of **interfaces** and **abstract classes** for extensibility and code reusability.

---

## Description

The E-Commerce Console App is built using core Java with modularized packages and classes for user management, product handling, cart functionality, and order processing. It uses Java collections (e.g., `ArrayList`) for in-memory storage of products and cart items.

---

## Objectives

- Demonstrate OOP principles: inheritance, polymorphism, encapsulation, and abstraction
- Implement business logic using interfaces and abstract classes
- Provide a simple yet interactive command-line shopping experience
- Simulate basic e-commerce operations like product listing, cart handling, and checkout

---

## Features

- Enter user details (name, email, address)
- View available products with ID, name, price, and stock
- Add products to the shopping cart using Product ID
- View current cart items
- Checkout: updates stock and displays total cost
- Graceful exit with user feedback

---

## Key Concepts Used

- **Object-Oriented Programming (OOP)**: Product, User, Cart, and Checkout are modeled using classes.
- **Interfaces**: Interfaces define behavior contracts such as `CartOperations`, `ProductOperations`, and `CheckoutProcess`.
- **Abstract Classes**: Abstract base classes like `AbstractProduct` provide reusable structure for product types.
- **Encapsulation**: Private fields with public getters/setters protect data.
- **Polymorphism**: Checkout and cart behaviors are implemented with runtime method dispatch via interfaces or abstract references.

---

## Tech Stack

- Java 21 (or any recent version)
- No external dependencies (fully in core Java)
- IDE: IntelliJ / Eclipse / VSCode (any)
- Build Tool: None (manual compile and run)

---

## Author

**Name:** Srigayatri  
**Date:** July 25, 2025

---

## How to Run

1. Compile all `.java` files:
