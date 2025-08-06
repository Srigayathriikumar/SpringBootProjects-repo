# Student Course Management System

## Introduction
The **Student Course Management System** is a Spring Boot REST API application designed to manage students, courses, and enrollments efficiently. This project demonstrates the implementation of a layered architecture using Spring Boot, Spring Data JPA, and RESTful principles.

## Description
This application allows administrators to perform CRUD operations on students and courses. It also provides functionality to manage enrollments, enabling students to be enrolled in multiple courses and retrieving course enrollments per student. The system leverages JPA entity mapping for relational data management and exposes all functionality via REST APIs.

## Features
- **Student Management:** Create, read, update, and delete students.
- **Course Management:** Create, read, update, and delete courses.
- **Enrollment Management:**
  - Enroll students in courses
  - View all enrollments
  - View courses by student
- **Layered Architecture:**
  - Entity Layer
  - Repository Layer (JpaRepository)
  - Service Layer (Interfaces + Implementations)
  - REST Controller Layer

## Tech Stack
- Java 17+
- Spring Boot
- Spring Data JPA
- H2 Database / PostgreSQL
- REST API (JSON)
- Maven

## API URLs
### Student APIs
- `GET /api/students` – Get all students with DTO
- `POST /api/students` – Create students with DTO  
- `GET /api/students/all` – Get all students  
- `GET /api/students/{id}` – Get student by ID  
- `POST /api/students/create` – Create new student  
- `PUT /api/students/update/{id}` – Update student  
- `DELETE /api/students/delete/{id}` – Delete student  

### Course APIs

- `GET /api/courses/all` – Get all courses  
- `GET /api/courses/{id}` – Get course by ID  
- `POST /api/courses/create` – Create new course  
- `PUT /api/courses/update/{id}` – Update course  
- `DELETE /api/courses/delete/{id}` – Delete course  

### Enrollment APIs
- `POST /api/enrollments/create` – Enroll a student in a course  
- `GET /api/enrollments/all` – View all enrollments  
- `GET /api/enrollments/student/courses/{studentId}` – View courses by student  

