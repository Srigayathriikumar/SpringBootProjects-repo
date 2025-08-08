# EventEase

## 📚 Introduction

**EventEase** is a comprehensive event management backend application built with Java and Spring Boot. It provides a robust RESTful API for managing events, users, and registrations, making it easy to create, update, and track events and participants. Designed for learning and practical use, EventEase demonstrates best practices in Java backend development, database design, and API architecture.

---

## 📝 Description

EventEase serves as a backend system for event organizers and participants. It allows administrators to manage events and users, and enables users to register for events. The application models real-world relationships between users, events, and registrations using JPA/Hibernate ORM and persists data in a PostgreSQL database. DTOs and mappers are used for clean API responses and requests.

---

## ✨ Features

- **Event Management:** Create, update, view, and delete events.
- **User Management:** Register, update, view, and delete users.
- **Registration:** Register users for events and view registrations.
- **Entity Relationships:** Models many-to-one and one-to-many relationships between users, events, and registrations.
- **Validation:** Input validation for user and event data.
- **Error Handling:** Meaningful error messages for invalid operations.
- **RESTful APIs:** Clean, well-structured endpoints for all operations.
- **DTO Mapping:** Uses MapStruct for mapping between entities and DTOs.
- **Database Integration:** Uses PostgreSQL for persistent storage.

---

## 🚀 API Endpoints

### Event APIs

| Method | Endpoint                  | Description                  |
|--------|---------------------------|------------------------------|
| GET    | `/api/events/all`         | Retrieve all events          |
| GET    | `/api/events/{id}`        | Retrieve event by ID         |
| POST   | `/api/events/create`      | Create a new event           |
| PUT    | `/api/events/update/{id}` | Update an existing event     |
| DELETE | `/api/events/delete/{id}` | Delete an event              |

### User APIs

| Method | Endpoint                  | Description                  |
|--------|---------------------------|------------------------------|
| GET    | `/api/users/all`          | Retrieve all users           |
| GET    | `/api/users/{id}`         | Retrieve user by ID          |
| POST   | `/api/users/create`       | Create a new user            |
| PUT    | `/api/users/update/{id}`  | Update an existing user      |
| DELETE | `/api/users/delete/{id}`  | Delete a user                |

### Registration APIs

| Method | Endpoint                                         | Description                           |
|--------|--------------------------------------------------|---------------------------------------|
| GET    | `/api/registrations/all`                         | Retrieve all registrations            |
| POST   | `/api/registrations/create`                      | Register a user for an event          |
| PUT    | `/api/registrations/register/{userId}/{eventId}` | Register user to event                |
| GET    | `/api/registrations/event/{eventId}`             | Get registration for a specific event |

---

---

## 🛠️ Tech Stack

- **Java 21**
- **Spring Boot 3**
- **Spring Data JPA**
- **PostgreSQL**
- **Maven**
- **JUnit** (unit testing)

---