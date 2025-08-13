# Bug Tracker Application

## Introduction
The Bug Tracker Application is a Spring Boot-based REST API for tracking and managing bugs in software projects. It provides comprehensive filtering and pagination capabilities for efficient bug management.

## Description
This application offers a complete solution for bug tracking with advanced search and filtering options. It supports pagination, sorting, and multiple filter criteria to help teams efficiently manage their bug reports. The application uses an in-memory database with preloaded sample data for quick testing and demonstration.

## Features
- List all bugs with pagination and sorting
- Search bugs by title with partial matching
- Filter bugs by status, assignee, and project
- Combined filtering with multiple criteria
- Pagination support with customizable page size
- Sorting by various fields (id, title, status, etc.)
- Preloaded sample data for testing
- RESTful API design

## APIs

| Method | Endpoint                                      | Description                                      |
|--------|-----------------------------------------------|--------------------------------------------------|
| GET    | `/api/bugs`                                   | Get all bugs with pagination                     |
| GET    | `/api/bugs/search`                            | Search bugs with filters and pagination         |
| GET    | `/api/bugs/bugsdata`                          | Get bugs with custom pagination parameters      |
| GET    | `/api/bugs/status/{status}`                   | Get bugs by status                               |
| GET    | `/api/bugs/assignee/{assignee}`               | Get bugs by assignee                             |
| GET    | `/api/bugs/project/{project}`                 | Get bugs by project                              |
| GET    | `/api/bugs/{status}/{assignee}/{project}`     | Get bugs by status, assignee, and project        |

## Tech Stack
- Java 17+
- Spring Boot 3.x
- Spring Data JPA
- Spring Security
- H2 Database (in-memory)
- RESTful API
- Maven