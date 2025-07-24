# User Registration Validation Console Application

## Description

This Java console application allows users to register by providing their details. It demonstrates object-oriented programming (OOP) principles and uses custom exceptions to validate user input. The application checks whether the user is above 18 years of age before allowing registration.

---

## Objectives

- Demonstrate core OOP concepts
- Implement custom exceptions for input validation
- Validate user registration details, including age restrictions
- Provide clear feedback and error handling for invalid user input
- Structure code using packages for better organization

---

## Features

- **User Registration:**  
  Users can register by entering their details (e.g., name, age, email) via the console.

- **Age Validation:**  
  The application checks if the user is above 18 years old. If not, registration is denied and a custom exception is thrown.

- **Custom Exception Handling:**  
  Invalid age or other input errors are handled gracefully using custom exception classes, providing meaningful error messages.

- **OOP Design:**  
  - User data is encapsulated in a `User` class.
  - Validation logic is separated into dedicated classes/methods.
  - Custom exceptions (e.g., `InvalidAgeExceptions`) are used for specific validation failures.

- **Extensible Structure:**  
  The codebase is organized into packages (e.g., `models`, `exceptions`, `services`) to support future features such as email validation, password strength checks, or database integration.

- **Console Interaction:**  
  All user interactions occur via the command line, with prompts and feedback for each step.

---

## Example Workflow

1. User is prompted to enter registration details.
2. Application validates the input, especially the age.
3. If the user is under 18, a custom exception is thrown and an error message is displayed.
4. If all validations pass, the user is successfully registered and a confirmation message is shown.

---

## Tech Stack

- **Java 17+**
- **Maven** (for build and dependency management)
- **VS Code** or any Java IDE

---

## Author

**Name:** Srigayathri K  
**Date:** July 24, 2025

---