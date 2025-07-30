# Springboot Sample Application

## Introduction

This project is developed as part of a Spring Boot learning series. It focuses on implementing the basic structure of a Spring Boot web application using embedded Tomcat, REST endpoints, and custom configuration.

## Description

`day7proj2phase1` is a simple Spring Boot application built with Java 17 and Spring Boot 3.x. It demonstrates how to set a custom server port using `application.properties`, how to organize code with clean package structures, and how to expose multiple REST endpoints that return plain text responses.

## Features

- Uses Spring Boot 3.x with Java 17
- Runs on a custom port (9090)
- Contains three REST endpoints returning plain text:
  - `/hello`: Returns a static greeting message
  - `/greet`: Returns a personalized greeting 
- Clean code structure using packages:
  - `controller` for REST endpoints
  - Main application class in root package
- Uses embedded Tomcat (default in Spring Boot)
- Built with Maven

## REST Endpoints

| Endpoint       | Method | Sample Output                                      |
|----------------|--------|----------------------------------------------------|
| `/hello`       | GET    | Hello, World! This is a Spring Boot application.   |
| `/greet`       | GET    | Greetings from the Spring Boot application!        |

## How to Run

1. Clone the repository
2. Open the project in your IDE
3. Run the main application class: `SpringbootGreetingApplication.java`
4. Visit the following URLs in your browser or Postman:

- [http://localhost:9090/hello](http://localhost:9090/hello)
- [http://localhost:9090/greet](http://localhost:9090/greet)

## Author

Srigayathri K

## Date

July 30, 2025
