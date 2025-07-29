package com.leavemanagementlite.controller;

import com.leavemanagementlite.entity.*;
import com.leavemanagementlite.exceptions.*;
import com.leavemanagementlite.services.UserService;

import java.time.LocalDate;
import java.util.Scanner;

public class UserController {
    Scanner sc = new Scanner(System.in);
    private UserService userService = new UserService();

    public void start() {
        while (true) {
            System.out.println("\n--- Leave Management Menu ---");
            System.out.println("1. Add Employee");
            System.out.println("2. Apply for Leave");
            System.out.println("3. Update Leave Status");
            System.out.println("4. Delete Leave Request");
            System.out.println("5.Display All Employees");
            System.out.println("6. Display All Leave Requests");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                 addemployee();
                 break;
                case 2:
                 applyleave();
                 break;
                case 3:
                 updatestatuseLeave();
                 break;
                case 4:
                 deleteleaverequest();
                 break;
                case 5:
                    displayallemployees();
                    break;
                case 6:
                    displayallleaverequests();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    return;
                
                default:
                 System.out.println("Invalid option.");
            }
        }
    }

    private void addemployee() {
         sc.nextLine(); 
        System.out.print("Name: ");
        String name =     sc.nextLine();
        System.out.print("Department: ");
        String dept =     sc.nextLine();
        System.out.print("Email: ");
        String email =     sc.nextLine();

        Employee emp = new Employee(0, name, dept, email);
        userService.addEmployee(emp);
        System.out.println("Employee added.");
    }

    private void applyleave() {
         sc.nextLine(); 
        System.out.print("Employee ID: ");
        int empId =     sc.nextInt();
         sc.nextLine();
        System.out.print("From Date (yyyy-mm-dd): ");
        LocalDate from = LocalDate.parse(sc.nextLine());
        System.out.print("To Date (yyyy-mm-dd): ");
        LocalDate to = LocalDate.parse(sc.nextLine());
        System.out.print("Reason: ");
        String reason = sc.nextLine();

        LeaveRequest request = new LeaveRequest(0, empId, from, to, reason, "Pending");
        try {
            userService.applyLeave(request);
            System.out.println("Leave applied.");
        } catch (InvalidLeaveDateException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void deleteleaverequest() {
        System.out.print("Enter Leave ID to delete: ");
        int leaveId =     sc.nextInt();
        userService.deleteleave(leaveId);
        System.out.println("Leave request deleted.");
    }

    private void updatestatuseLeave() {
        System.out.print("Enter Leave ID to update status: ");
        int leaveId =     sc.nextInt();
         sc.nextLine();
        System.out.print("Enter new status (Approved/Rejected): ");
        String status =     sc.nextLine();

        userService.updatestatus(leaveId, status);
        System.out.println("Leave status updated.");
    }

    private void displayallemployees() {
        userService.displayallemployees();
    }

    private void displayallleaverequests() {
        userService.displayallleaverequests();
    }
}
