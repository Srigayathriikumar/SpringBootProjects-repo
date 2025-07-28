# 🐞 JDBC Bug Tracker

## 📘 Introduction

JDBC Bug Tracker is a simple **console-based Java application** built with JDBC and PostgreSQL. It allows users to manage software bug reports through a menu-driven interface. The project is structured with clear separation between layers—Entity, Repository, Service, Controller, and Utility.

---

## 📝 Description

This project showcases a CRUD application that interacts with a PostgreSQL database using raw JDBC (no ORM frameworks).It follows the **SOLID Principles** and **ONION Architecture**.


---

## 🚀 Features

- ✅ **Create Bug**: Add a new bug report with title and status.
- 📄 **Read Bugs**: List all bugs from the database.
- 🔄 **Update Bug Status**: Modify the status of a specific bug using its ID.
- ❌ **Delete Bug**: Remove a bug entry by its ID.
- 🔗 **JDBC Integration**: Uses JDBC to connect and run queries on PostgreSQL.
- 🧩 **Layered Architecture**: Clean separation of concerns for better maintainability.

---

## 🛠️ Tech Stack

- **Java** 17+
- **PostgreSQL** (13 or newer recommended)
- **JDBC**
- **Maven** (optional, for dependency and build management)

---

## 📂 Folder Structure Overview

| Package         | Description                              |
|-----------------|------------------------------------------|
| `entity`        | Java class representing the Bug object   |
| `repository`    | Interface and implementation for DB ops  |
| `service`       | Business logic for handling bugs         |
| `controller`    | Console-based controller for interaction |
| `util`          | DB connection utility using JDBC         |
| `Main.java`     | Entry point for launching the app        |

---

## 👤 Author

**Srigayathri K**  
📅 July 28, 2025

---

## 🏁 Future Improvements (Optional)

- Add support for bug priority and categories  
- Switch to Spring JDBC Template or JPA  
- Add unit testing with JUnit and Mockito  
- Introduce a CLI or GUI frontend

---



