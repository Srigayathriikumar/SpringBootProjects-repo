package com.day5proj2;

import com.day5proj2.dao.BugDAO;
import com.day5proj2.models.Bug;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        BugDAO dao = new BugDAO();
        int choice;

        do {
            System.out.println("\n--- MINI ISSUE TRACKER ---");
            System.out.println("1. Add Bug");
            System.out.println("2. View All Bugs");
            System.out.println("3. Update Bug Status");
            System.out.println("4. Delete Bug");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = s.nextInt();
            s.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter Bug Title: ");
                    String title = s.nextLine();
                    System.out.print("Enter Description: ");
                    String description = s.nextLine();
                    System.out.print("Enter Status: ");
                    String status = s.nextLine();
                    dao.insertbug(new Bug(title, description, status));
                    break;

                case 2:
                    List<Bug> bugs = dao.getallbugs();
                    if (bugs.isEmpty()) {
                        System.out.println("No bugs found.");
                    } else {
                        for (Bug b : bugs) {
                            System.out.println("\nBug ID: " + b.getId());
                            System.out.println("Title: " + b.getTitle());
                            System.out.println("Description: " + b.getDescription());
                            System.out.println("Status: " + b.getStatus());
                            System.out.println("-----------------------------");
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Bug ID to update: ");
                    int idToUpdate = s.nextInt();
                    s.nextLine();
                    System.out.print("Enter new status: ");
                    String newStatus = s.nextLine();
                    dao.updateStatus(idToUpdate, newStatus);
                    break;

                case 4:
                    System.out.print("Enter Bug ID to delete: ");
                    int idToDelete = s.nextInt();
                    dao.deleteBug(idToDelete);
                    break;

                case 5:
                    System.out.println(" Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 5);

        s.close();
    }
}
