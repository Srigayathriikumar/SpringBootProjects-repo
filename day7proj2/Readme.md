# day7proj2-weatherapp

## Introduction
`day7proj2-weatherapp` is a simple Spring Boot application developed as part of a learning module (Day 7 – Project 2). The goal is to simulate a basic weather service using REST APIs, with hardcoded responses and dynamic path variables. It focuses on core Spring Boot features and clean code organization.

## Description
This project demonstrates how to build a minimal RESTful web service using Spring Boot 3.x and Java 17. The application exposes three endpoints that return plain text weather updates. It runs on a custom port and showcases the use of embedded Tomcat, path variables, and externalized configuration through `application.properties`.

## Features
- REST API with multiple GET endpoints
- Dynamic path variable support (city name)
- Embedded Tomcat server
- Custom server port configuration (8085)
- Clean and modular code structure

## Endpoints and Sample Outputs
| Endpoint                  | Output                                                   |
|---------------------------|----------------------------------------------------------|
| `/weather/today`          | Today's weather: Sunny, 30°C                             |
| `/weather/tomorrow`       | Tomorrow's forecast: Cloudy with rain                    |
| `/weather/city/Mumbai`    | Weather report for Mumbai is currently unavailable.      |

## Technology Stack
- Java 17
- Spring Boot 3.x
- Maven
- Spring Web (spring-boot-starter-web)

## How to Run
1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/day7proj2.git
   cd day7proj2-weatherapp

## Build and run the application:
        -mvn spring-boot:run

## Access the service at:

http://localhost:8085/weather/today

http://localhost:8085/weather/tomorrow

http://localhost:8085/weather/city/Mumbai

