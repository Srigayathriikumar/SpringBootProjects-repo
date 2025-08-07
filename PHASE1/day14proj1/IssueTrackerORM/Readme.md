#  Issue Tracker ORM

A simple issue tracking system built with **Spring Boot**, using **Spring Data JPA** and a **PostgreSQL** database. The application allows users to manage projects, assign users, and track bugs in a structured and scalable way.

---

## Introduction

This project is designed to demonstrate a clean and modular approach to building a RESTful backend using Java Spring Boot and ORM (Hibernate JPA). The system supports:

- Creating and managing **users**
- Managing **projects**
- Tracking **bugs** associated with projects

---

##  Description

This backend application supports the following:

- Managing Users with roles (e.g., Manager, Developer)
- Managing Projects with project names and associated bugs
- Reporting and retrieving Bugs tied to specific projects

Data is persisted using **PostgreSQL** and accessed through **Spring Data JPA** repositories.

---

##  Features

- RESTful API for CRUD operations
- Separate services and controllers for `User`, `Project`, and `Bug`
- Uses `@OneToMany` and `@ManyToOne` relationships between entities
- Uses Spring Boot's dependency injection and auto-configuration
- Organized into `Controller`, `Service`, `Repository`, and `Domain` layers

---

## Tech Stack

| Layer         | Technology            |
|--------------|------------------------|
| Language      | Java 17+               |
| Framework     | Spring Boot            |
| ORM           | Spring Data JPA (Hibernate) |
| Database      | PostgreSQL             |
| Build Tool    | Maven                  |
| JSON Handling | Jackson (via Spring)   |
| Testing Tools | Postman (API testing)  |

---

##  API Endpoints

### 🔹 User Endpoints

| Method | URL                    | Description               |
|--------|------------------------|---------------------------|
| GET    | `/api/users`           | Get all users             |
| GET    | `/api/users/{id}`      | Get user by ID            |
| POST   | `/api/users/create`    | Create a new user         |
| GET    | `/api/bugs`            | Get all bugs with DTO     |
| POST   | `/api/bugs`            | Create bugs with DTO      |


 Sample JSON:

```json
{
  "username": "swathi",
  "role": "Manager"
}
---

Author : Srigayathri K
