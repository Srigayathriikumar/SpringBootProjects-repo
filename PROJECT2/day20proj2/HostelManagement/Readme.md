# Hostel Management System

## Introduction
The Hostel Management System is a Spring Boot application designed to manage students, staff, and room assignments in a hostel environment. It provides RESTful APIs for querying and managing hostel data efficiently.

## Description
This project demonstrates a simple backend for hostel management, including student and staff registration, room allocation, and filtering capabilities. The application uses Spring Boot, JPA, and an in-memory database for demonstration and testing purposes.

## Features
- Register and manage students and staff
- Assign students to rooms and staff
- Filter students by room number or assigned staff
- Preloaded sample data for quick testing

## API Endpoints

| Method | Endpoint                        | Description                                 |
|--------|---------------------------------|---------------------------------------------|
| GET    | `/students/{roomno}/{assignedto}` | Get students filtered by room and staff     |
| GET    | `/students/room/{roomno}`         | Get students by room number                 |
| GET    | `/students/staff/{assignedto}`    | Get students by assigned staff              |

## Tech Stack
- Java 17+
- Spring Boot
- Spring Data JPA
- H2 Database (in-memory)