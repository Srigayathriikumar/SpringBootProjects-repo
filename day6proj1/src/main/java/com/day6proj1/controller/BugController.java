package com.day6proj1.controller;

import com.day6proj1.entity.Bug;
import com.day6proj1.services.BugService;
import java.util.List;
import java.util.Scanner;
public class BugController {
    private final BugService bugservice;
    private Scanner sc = new Scanner(System.in);

    public BugController(BugService bugservice) {
        this.bugservice = bugservice;
    }

    public void run() {
        while (true) {
            System.out.println("\n1. Create Bug\n2. View All Bugs\n3. Quit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                 createBug();
                 break;
                case 2:
                 displayAllBugs();
                 break;
                case 3 :
                    System.out.println("-------------QUIT--------------");
                    return;
                
                default:
                 System.out.println("Invalid choice.");
                 break;
            }
        }
    }

    private void createBug() {
        System.out.print("Enter bug title: ");
        String title = sc.nextLine();
        System.out.print("Enter bug description: ");
        String description = sc.nextLine();
        System.out.print("Enter bug status: ");
        String status = sc.nextLine();
        bugservice.createBug(title, description, status);
        System.out.println("Bug created successfully.");
    }

    private void displayAllBugs() {
        List<Bug> bugs = bugservice.getAllBugs();
        if (bugs.isEmpty()) {
            System.out.println("No bugs found");
        } else {
            System.out.println("\nBug List:");
            for (Bug bug : bugs) {
                System.out.println("ID: " + bug.getId());
                System.out.println("Title: " + bug.getTitle());
                System.out.println("Description: " + bug.getDescription());
                System.out.println("Status: " + bug.getStatus());
                System.out.println("------------------------");
            }
        }
    }
}
