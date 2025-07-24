#  Issue Tracker - Spring Boot (Maven)

##  Description

A simple Java console-based Spring Boot application to demonstrate core Object-Oriented Programming (OOP) principles such as inheritance, polymorphism, and interface implementation. This application simulates an issue tracking system with two issue types: **Bug** and **Task**. It does **not** use REST APIs or Spring MVC, and instead focuses purely on Java logic within the `main()` method.

---

##  Objectives

- Create a Spring Boot project using Maven
- Implement:
  - Base class: `Issue`
  - Derived classes: `Bug`, `Task`
  - Interface: `Reportable`
- Demonstrate:
  - Inheritance
  - Method overriding and polymorphism
  - Interface-based method calls
- Contain all logic inside the `main()` method of `IssueTrackerApplication`
- Avoid usage of REST controllers or endpoints

---

##  Features

- Create and manage `Bug` and `Task` objects
- Store them in a list of `Issue` references
- Display issue details using overridden `display()` method (polymorphism)
- Call `reportStatus()` using `Reportable` interface references
- Organized package structure for `model` and `main`

---

## Tech Stack

- **Java 17**
- **Spring Boot**
- **Maven**
- **VS Code** (or any Java IDE)
- No external dependencies beyond Spring Boot Starter

---

##  Author

**Name:** Srigayathri K  
**Date:** July 23, 2025

---


