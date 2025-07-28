package com.day6proj2.controller;
import com.day6proj2.entity.Bug;
import com.day6proj2.services.BugService;
import java.util.List;
import java.util.Scanner;
public class BugController {
    private BugService bugservice;
    Scanner sc = new Scanner(System.in);

    public BugController(BugService bugservice) {
        this.bugservice = bugservice;
    }

    public void run() {
        while (true) {
            System.out.println("------MENU------\n1. Create Bug\n2. View All Bugs\n3.Update Bug status\n4.Delete Bug\n5. Quit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                 createBug();
                 System.out.println("==============================");
                 break;
                case 2:
                 displayAllBugs();
                 System.out.println("==============================");
                 break;
                 case 3:
                 updateBug();
                 System.out.println("==============================");
                 break;
                 case 4:
                    deleteBug();
                    System.out.println("==============================");
                    break;
                case 5 :
                    System.out.println("-------------QUIT--------------");
                    return;
                
                default:
                 System.out.println("Invalid choice.");
                 System.out.println("==============================");
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
    private void updateBug() {
        System.out.print("Enter bug ID to update: ");
        int id = sc.nextInt();
        sc.nextLine(); 
        System.out.print("Enter new status: ");
        String newstatus = sc.nextLine();
        Bug bug = bugservice.getBugById(id);
        if (bug != null) {
            bug.setStatus(newstatus);
            bugservice.updateBug(bug);
            
        } else {
            System.out.println("Bug not found with ID: " + id);
        }
    }
    private void deleteBug() {
        System.out.print("Enter bug ID to delete: ");
        int id = sc.nextInt();
        sc.nextLine();
        Bug bug = bugservice.getBugById(id);
        if (bug != null) {
            bugservice.deleteBug(bug);
            
        } else {
            System.out.println("Bug not found with ID: " + id);
        }
    }
}
