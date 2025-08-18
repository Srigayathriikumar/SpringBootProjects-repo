# BankPro Application

## Introduction
BankPro is a comprehensive banking management system built with Spring Boot that provides essential banking operations including customer management, account handling, and transaction processing.

## Description
This application simulates a banking system where customers can have multiple accounts, perform transactions, and manage their banking activities. It follows a layered architecture with proper separation of concerns using controllers, services, repositories, and DTOs.

## Features
- **Customer Management**: Create, read, update, and delete customer information
- **Account Management**: Handle different account types (Savings/Current) with balance tracking
- **Transaction Processing**: Support for credit/debit transactions between accounts
- **Paginated Transaction History**: View account transaction history with pagination
- **Data Validation**: Email format validation and input validation
- **RESTful APIs**: Complete REST API endpoints for all operations
- **Sample Data**: Pre-loaded with sample customers, accounts, and transactions

## Tech Stack
- **Backend**: Spring Boot 3.x
- **Database**: H2 (In-memory)
- **ORM**: Spring Data JPA / Hibernate
- **Validation**: Jakarta Bean Validation
- **Security**: Spring Security (Basic configuration)
- **Build Tool**: Maven
- **Java Version**: 17+

## API Endpoints

### Customer APIs
- `GET /customers` - Get all customers
- `GET /customers/{id}` - Get customer by ID
- `POST /customers/admin` - Create new customer
- `PUT /customers/admin/{id}` - Update customer
- `DELETE /customers/admin/{id}` - Delete customer

### Account APIs
- `GET /accounts` - Get all accounts
- `GET /accounts/{id}` - Get account by ID
- `POST /accounts/admin` - Create new account
- `PUT /accounts/admin/{id}` - Update account
- `DELETE /accounts/admin/{id}` - Delete account

### Transaction APIs
- `GET /api/transactions/account/{accountId}` - Get paginated transaction history
- `POST /api/transactions/transfer` - Create transaction between accounts

## Getting Started
1. Clone the repository
2. Run `mvn spring-boot:run`
3. Access the application at `http://localhost:9094`
4. Use the API endpoints to interact with the banking system

## Sample Data
The application comes pre-loaded with:
- 5 sample customers
- 5 sample accounts (linked to customers)
- 5 sample transactions