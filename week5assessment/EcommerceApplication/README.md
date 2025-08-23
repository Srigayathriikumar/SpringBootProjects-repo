# Ecommerce Application

A comprehensive Spring Boot REST API application for managing an ecommerce platform with user management, product catalog, and order processing capabilities.

## Description

This application provides a complete backend solution for an ecommerce system built with Spring Boot 3.5.5. It features role-based authentication, CRUD operations for users, products, and orders, along with advanced filtering and pagination capabilities.

## Features

- **User Management**: Registration, authentication, and profile management
- **Product Catalog**: Complete product CRUD with category and price filtering
- **Order Processing**: Place orders, view order history with pagination
- **Role-Based Security**: ADMIN and USER roles with method-level authorization
- **Advanced Filtering**: Filter products by category, price range, and availability
- **Pagination & Sorting**: Efficient data retrieval with customizable page sizes
- **API Documentation**: Interactive Swagger UI for testing endpoints
- **Comprehensive Testing**: Unit tests with Mockito framework

## Tech Stack

- **Framework**: Spring Boot 3.5.5
- **Security**: Spring Security with HTTP Basic Auth
- **Database**: H2 In-Memory Database
- **ORM**: Spring Data JPA with Hibernate
- **Documentation**: SpringDoc OpenAPI 2.7.0 (Swagger)
- **Testing**: JUnit 5, Mockito
- **Build Tool**: Maven
- **Java Version**: 17+

## User Roles

### ADMIN Role
- Full access to product management (Create, Read, Update, Delete)
- View all users and orders
- Complete system administration privileges

### USER Role  
- View products and filter by category/price
- Place and manage personal orders
- View personal order history
- Update personal profile information

## API Endpoints

### Authentication
- `POST /api/auth/login` - User login with credentials

### User Management
- `POST /api/users` - Register new user
- `GET /api/users` - Get all users (ADMIN only)
- `GET /api/users/{id}` - Get user by ID
- `PUT /api/users/{id}` - Update user profile
- `DELETE /api/users/{id}` - Delete user (ADMIN only)

### Product Management
- `POST /api/products` - Create new product (ADMIN only)
- `GET /api/products` - Get all products with pagination
  - Query params: `page`, `size`, `sort`
- `GET /api/products/{id}` - Get product by ID
- `PUT /api/products/{id}` - Update product (ADMIN only)
- `DELETE /api/products/{id}` - Delete product (ADMIN only)
- `GET /api/products/filter` - Filter products
  - Query params: `category`, `minPrice`, `maxPrice`, `page`, `size`
- `GET /api/products/category/{category}` - Get products by category
- `GET /api/products/price-range` - Get products by price range
  - Query params: `minPrice`, `maxPrice`

### Order Management
- `POST /api/orders` - Place new order (USER only)
- `GET /api/orders/user/{userId}` - Get user orders with pagination
  - Query params: `page`, `size`
- `GET /api/orders/{id}` - Get order by ID
- `GET /api/orders` - Get all orders (ADMIN only)

### Order Item Management
- `POST /api/order-items` - Create order item
- `GET /api/order-items` - Get all order items
- `GET /api/order-items/{id}` - Get order item by ID
- `PUT /api/order-items/{id}` - Update order item
- `DELETE /api/order-items/{id}` - Delete order item

## Getting Started

### Prerequisites
- Java 17 or higher
- Maven 3.6+

### Installation
1. Clone the repository
2. Navigate to project directory
3. Run the application:
   ```bash
   mvn spring-boot:run
   ```

### Access Points
- **Application**: http://localhost:8080
- **H2 Database Console**: http://localhost:8080/h2-console
- **API Documentation**: http://localhost:8080/swagger-ui.html

### Default Credentials
- **Database**: 
  - URL: `jdbc:h2:mem:testdb`
  - Username: `sa`
  - Password: (empty)

## Testing

Run unit tests with Maven:
```bash
mvn test
```

The application includes comprehensive test coverage for all service layers using Mockito framework.

## Project Structure

```
EcommerceApplication/
├── .mvn/
│   └── wrapper/
│       └── maven-wrapper.properties
├── src/
│   ├── main/
│   │   ├── java/com/example/EcommerceApplication/
│   │   │   ├── config/
│   │   │   │   ├── SecurityConfig.java          # Spring Security Configuration
│   │   │   │   └── SwaggerConfig.java           # API Documentation Config
│   │   │   ├── controller/
│   │   │   │   ├── AuthController.java          # Authentication endpoints
│   │   │   │   ├── OrderController.java         # Order management APIs
│   │   │   │   ├── OrderItemController.java     # Order item APIs
│   │   │   │   ├── ProductController.java       # Product management APIs
│   │   │   │   └── UserController.java          # User management APIs
│   │   │   ├── domain/
│   │   │   │   ├── Login.java                   # Login entity
│   │   │   │   ├── Order.java                   # Order entity
│   │   │   │   ├── OrderItem.java               # Order item entity
│   │   │   │   ├── Product.java                 # Product entity
│   │   │   │   └── User.java                    # User entity
│   │   │   ├── dto/
│   │   │   │   ├── LoginRequestDTO.java         # Login request DTO
│   │   │   │   ├── LoginResponseDTO.java        # Login response DTO
│   │   │   │   ├── OrderRequestDTO.java         # Order request DTO
│   │   │   │   ├── OrderResponseDTO.java        # Order response DTO
│   │   │   │   ├── ProductRequestDTO.java       # Product request DTO
│   │   │   │   ├── ProductResponseDTO.java      # Product response DTO
│   │   │   │   ├── UserRequestDTO.java          # User request DTO
│   │   │   │   └── UserResponseDTO.java         # User response DTO
│   │   │   ├── exception/
│   │   │   │   ├── GlobalExceptionHandler.java  # Global error handling
│   │   │   │   ├── ItemOutOfStockException.java # Custom exception
│   │   │   │   └── ResourceNotFoundException.java # Custom exception
│   │   │   ├── mapper/
│   │   │   │   ├── OrderMapper.java             # Order DTO mapping
│   │   │   │   ├── ProductMapper.java           # Product DTO mapping
│   │   │   │   └── UserMapper.java              # User DTO mapping
│   │   │   ├── repository/
│   │   │   │   ├── OrderItemRepository.java     # Order item data access
│   │   │   │   ├── OrderRepository.java         # Order data access
│   │   │   │   ├── ProductRepository.java       # Product data access
│   │   │   │   └── UserRepository.java          # User data access
│   │   │   ├── service/
│   │   │   │   ├── JwtAuthFilter.java           # JWT authentication filter
│   │   │   │   ├── JwtService.java              # JWT token service
│   │   │   │   ├── OrderItemService.java        # Order item service interface
│   │   │   │   ├── OrderItemServiceImpl.java    # Order item service impl
│   │   │   │   ├── OrderService.java            # Order service interface
│   │   │   │   ├── OrderServiceImpl.java        # Order service implementation
│   │   │   │   ├── ProductService.java          # Product service interface
│   │   │   │   ├── ProductServiceImpl.java      # Product service impl
│   │   │   │   ├── UserService.java             # User service interface
│   │   │   │   └── UserServiceImpl.java         # User service implementation
│   │   │   └── EcommerceApplication.java        # Main application class
│   │   └── resources/
│   │       ├── static/                          # Static web resources
│   │       ├── templates/                       # Template files
│   │       └── application.properties           # Application configuration
│   └── test/
│       └── java/com/example/EcommerceApplication/
│           ├── service/
│           │   ├── OrderServiceTest.java        # Order service unit tests
│           │   ├── ProductServiceTest.java      # Product service unit tests
│           │   └── UserServiceTest.java         # User service unit tests
│           └── EcommerceApplicationTests.java   # Integration tests
├── target/                                      # Compiled classes (generated)
├── .gitattributes                               # Git attributes
├── .gitignore                                   # Git ignore rules
├── HELP.md                                      # Spring Boot help
├── mvnw                                         # Maven wrapper (Unix)
├── mvnw.cmd                                     # Maven wrapper (Windows)
├── pom.xml                                      # Maven configuration
└── README.md                                    # Project documentation
```