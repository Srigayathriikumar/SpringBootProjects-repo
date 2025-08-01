# HelpDeskORM

A Spring Boot application designed to streamline help desk ticket management using Object-Relational Mapping (ORM). This project provides a robust backend for creating, updating, and tracking support tickets with role-based access and RESTful APIs.

## Features

- Create, update, and manage help desk tickets
- Role-based access for users and administrators
- Ticket status tracking and management
- RESTful API endpoints for ticket operations
- Database integration using JPA/Hibernate

## Tech Stack

- Java 17+
- Spring Boot
- Spring Data JPA
- Hibernate
- H2/MySQL/PostgreSQL (configurable)
- Maven

## OUTPUT 


Welcome to the Help Desk ORM Application!
1. Create user
2. create support ticket
3. Assign ticket to support agent
4. Resolve ticket
5. View tickets(from JDBC)
6. Exit
Please select an option:
1
Creating user...
Enter username:
james
Enter email:
james123@gmail.com

Creating user: 
Username: 
Email: james123@gmail.com
User created successfully
---------------------------


Welcome to the Help Desk ORM Application!
1. Create user
2. create support ticket
3. Assign ticket to support agent
4. Resolve ticket
5. View tickets(from JDBC)
6. Exit
Please select an option:
2
Creating support ticket...
Enter ticket ID:
2
Enter ticket description:
button malfunction
Enter ticket status:
opened
Enter created by user:
william
Enter assigned to user:
james
Support ticket created successfully!
---------------------------

Welcome to the Help Desk ORM Application!
1. Create user
2. create support ticket
3. Assign ticket to support agent
4. Resolve ticket
5. View tickets(from JDBC)
6. Exit
Please select an option:
3
Enter ticket ID to assign:
2
Enter assigned agent username:
swathi
Ticket assigned successfully to swathi for ticket ID: 2
---------------------------


Welcome to the Help Desk ORM Application!
1. Create user
2. create support ticket
3. Assign ticket to support agent
4. Resolve ticket
5. View tickets(from JDBC)
6. Exit
Please select an option:
3
Enter ticket ID to assign:
2
Enter assigned agent username:
kalai
Ticket assigned successfully to kalai for ticket ID: 2
---------------------------


Welcome to the Help Desk ORM Application!
1. Create user
2. create support ticket
3. Assign ticket to support agent
4. Resolve ticket
5. View tickets(from JDBC)
6. Exit
Please select an option:
4
Resolving ticket
Enter ticket ID to resolve:
2
Ticket status updated to 'Closed' for ticket ID: 2
---------------------------


Welcome to the Help Desk ORM Application!
1. Create user
2. create support ticket
3. Assign ticket to support agent
4. Resolve ticket
5. View tickets(from JDBC)
6. Exit
Please select an option:
5
Viewing tickets from JDBC...
Tickets:
SupportTicket{ticketId=1, Description='new login error', status='Closed', created_by='james', assigned_to='jathin'}
SupportTicket{ticketId=2, Description='button malfunction', status='Resolved', created_by='william', assigned_to='kalai'}
---------------------------

5
Viewing tickets from JDBC...
Tickets:
SupportTicket{ticketId=1, Description='new login error', status='Closed', created_by='james', assigned_to='jathin'}
SupportTicket{ticketId=2, Description='button malfunction', status='Resolved', created_by='william', assigned_to='kalai'}
---------------------------

Tickets:
SupportTicket{ticketId=1, Description='new login error', status='Closed', created_by='james', assigned_to='jathin'}
SupportTicket{ticketId=2, Description='button malfunction', status='Resolved', created_by='william', assigned_to='kalai'}
---------------------------

SupportTicket{ticketId=1, Description='new login error', status='Closed', created_by='james', assigned_to='jathin'}
SupportTicket{ticketId=2, Description='button malfunction', status='Resolved', created_by='william', assigned_to='kalai'}
---------------------------

SupportTicket{ticketId=2, Description='button malfunction', status='Resolved', created_by='william', assigned_to='kalai'}
---------------------------


---------------------------



Welcome to the Help Desk ORM Application!
1. Create user
2. create support ticket
2. create support ticket
3. Assign ticket to support agent
4. Resolve ticket
5. View tickets(from JDBC)
6. Exit
6. Exit
Please select an option:
6
Exiting application...
---------------------------------

## Rest API OUTPUT

[
    {
        "id": 1,
        "description": "New login error",
        "status": "Closed",
        "created_by":"james",
        "assigned_to":"jathin"
        
    }
    {
        "id": 2,
        "description": "button malfunction",
        "status": "Resolved",
        "created_by":"william",
        "assigned_to":"kalai"
        
    }
]

---

## Author

Srigayathri K

_Date: June 2024_
