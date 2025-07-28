# 🐞 Mini Issue Tracker (DAY 5 PROJECT 2)– Console Application

The **Mini Issue Tracker** is a console-based Java application that helps developers manage and track bugs in a lightweight, structured manner. Designed as a learning project, it demonstrates how to build a CRUD-based system using **JDBC** for database connectivity and **PostgreSQL** as the backend database.

This application follows a layered architecture with clear separation of concerns (Model, DAO, Utility, and Main classes), making it easier to maintain and scale in the future.

---

## 📌 Features

- **Add Bug** – Insert a new issue with a title, description, and status.
- **View All Bugs** – Display all bugs currently stored in the database.
- **Update Bug Status** – Modify the status of an existing bug using its unique ID.
- **Delete Bug** – Remove a bug record from the system based on its ID.
- **Exit** – Safely terminate the application.

Each operation is accessed through a **menu-driven console interface**, providing an intuitive user experience.

---

## 🧰 Tech Stack

| Layer              | Technology      |
|-------------------|-----------------|
| Programming        | Java (JDK 17+)  |
| Database           | PostgreSQL      |
| Connectivity       | JDBC            |
| Input Handling     | Scanner (Console) |
| Architecture       | DAO Pattern     |

---

## 🗄️ Architecture Overview

- **`model`** → Contains the `Bug` class representing the bug entity.
- **`dao`** → Contains the `BugDAO` class for database operations (insert, read, update, delete).
- **`util`** → Contains `DBUtil` to manage PostgreSQL DB connection.
- **`Main`** → Contains the menu logic and user interaction.
- **`services`** (optional) → Reserved for future business logic handling if needed.

---

## 📊 Sample Bug Table (PostgreSQL)

```sql
CREATE TABLE bugs (
    id SERIAL PRIMARY KEY,
    title VARCHAR(100),
    description TEXT,
    status VARCHAR(50)
);

--- 

## Author : Srigayathri K
## Date : 25-07-2025