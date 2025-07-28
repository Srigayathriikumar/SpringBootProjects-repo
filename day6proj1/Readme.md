# JDBC Bug Tracker (following SOLID Principles and ONION Architecture)

## 📘 Introduction

A simple console-based Java application that demonstrates CRUD operations using JDBC with a PostgreSQL database. The application manages bug reports, allowing users to view, add, update, and delete bug entries via a controller-driven console interface.

---

## 📝 Description

This project is structured using a layered architecture:
- **Entity**: Represents the Bug model as a Plain Old Java Object.
- **Repository**: Defines and implements JDBC-based database operations for bugs.
- **Service**: Contains the core business logic and bridges the controller and repository.
- **Controller**: Acts as the user-facing console interface to interact with the application.
- **Util**: Utility class for database connectivity.
- **Main**: Entry point of the application.

**The output is printed directly in the console in a structured format like:**
- ID: 1, Title: Null Pointer, Status: Open
- ID: 2, Title: UI Lag, Status: InProgress

---

## 🚀 Features

- Add new bug reports
- View all existing bugs
- Update bug status
- Delete bug entries
- JDBC-based PostgreSQL connectivity
- Clean separation of concerns (Layered architecture)

---

## 🛠️ Tech Stack

- **Java** 17+
- **PostgreSQL**
- **JDBC**
- **Maven** (for dependency management, if applicable)

---

## 👤 Author

**Srigayathri K**  
📅 July 28, 2025

---

