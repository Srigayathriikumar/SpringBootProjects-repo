# LeaveManagementLite

## 📝 Introduction
**LeaveManagementLite** is a Java-based console application designed to manage employee leave requests efficiently. It provides essential CRUD operations, status tracking, and user interaction via a text-based menu system.

---

## 📄 Project Description
This project follows a modular, layered architecture using Java, JDBC, and Maven. It simulates a real-world Leave Management System for employees and managers, with proper separation of concerns across entity, service, DAO, and controller layers.

The system includes features like:
- Employee data management
- Leave request submission and validation
- Leave approval status tracking
- Database persistence using JDBC and PostgreSQL/MySQL

---

## ✨ Features
- Add and manage employees
- Apply for leave with validation
- View leave requests by employee or status
- Approve or reject leave applications
- Custom exception handling
- Structured console-based UI

---

## 🧰 Tech Stack
- Java 17+
- Maven
- JDBC
- PostgreSQL / MySQL
- Console (CLI) Application

---

## 📸 Sample Output

> ⚠️ _Sample console output will be added here after full implementation._

## output ##

--- Leave Management Menu ---
1. Add Employee
2. Apply for Leave
3. Update Leave Status
4. Delete Leave Request
5.Display All Employees
6. Display All Leave Requests
7. Exit
Choose an option: 1
---
Name: Watson
Department: Testing
Email: watson.t@gmail.com
Employee added.
---
--- Leave Management Menu ---
1. Add Employee
2. Apply for Leave
3. Update Leave Status
4. Delete Leave Request
5.Display All Employees
6. Display All Leave Requests
7. Exit
Choose an option: 2
---
Employee ID: 2 
From Date (yyyy-mm-dd): 2025-09-02
To Date (yyyy-mm-dd): 2025-09-10
Reason: Vacation
Leave applied.
---
--- Leave Management Menu ---
1. Add Employee
2. Apply for Leave
3. Update Leave Status
4. Delete Leave Request
5.Display All Employees
6. Display All Leave Requests
7. Exit
Choose an option: 3
---
Enter Leave ID to update status: 6
Enter new status (Approved/Rejected): Rejected
Leave status updated.
---
--- Leave Management Menu ---
1. Add Employee
2. Apply for Leave
3. Update Leave Status
4. Delete Leave Request
5.Display All Employees
6. Display All Leave Requests
7. Exit
Choose an option: 4
---
Enter Leave ID to delete: 3
Leave request deleted.
---
--- Leave Management Menu ---
1. Add Employee
2. Apply for Leave
3. Update Leave Status
4. Delete Leave Request
5.Display All Employees
6. Display All Leave Requests
7. Exit
Choose an option: 5
---
1 | jake | HR | jake.hr@gmail.com
2 | felix | dev | felix.s@gmail.com
3 | Watson | Testing | watson.t@gmail.com
---
--- Leave Management Menu ---
1. Add Employee
2. Apply for Leave
3. Update Leave Status
4. Delete Leave Request
5.Display All Employees
6. Display All Leave Requests
7. Exit
Choose an option: 6
---
4 | 2 | 2025-08-02 | 2025-08-30 | medical leave | Pending
5 | 1 | 2025-08-21 | 2025-08-28 | health issue | Pending
6 | 2 | 2025-09-02 | 2025-09-10 | Vacation | Rejected
---
--- Leave Management Menu ---
1. Add Employee
2. Apply for Leave
3. Update Leave Status
4. Delete Leave Request
5.Display All Employees
6. Display All Leave Requests
7. Exit
Choose an option: 7
---
Exiting...

---

## Author : Srigayathri K
## Date : 29-07-2025