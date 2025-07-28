package com.day5proj1phase2;
import com.day5proj1phase2.models.Bug;
import com.day5proj1phase2.services.BugService;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BugService service = new BugService();
        int choice;

        do {
            System.out.println("\n--- BUG TRACKER MENU ---");
            System.out.println("1. Insert a new bug");
            System.out.println("2. View all bugs");
            System.out.println("3. Delete a bug by ID");
            System.out.println("4. Update bug status by ID");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter bug title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter description: ");
                    String desc = sc.nextLine();
                    System.out.print("Enter status: ");
                    String status = sc.nextLine();
                    Bug bug = new Bug(title, desc, status);
                    service.addBug(bug);
                    break;

                case 2:
                    List<Bug> bugs = service.viewAllBugs();
                    for (Bug b : bugs) {
                        System.out.println(b);
                    }
                    break;

                case 3:
                    System.out.print("Enter Bug ID to delete: ");
                    int deleteId = sc.nextInt();
                    service.deleteBug(deleteId);
                    break;

                case 4:
                    System.out.print("Enter Bug ID to update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter new status: ");
                    String newStatus = sc.nextLine();
                    service.updateBugStatus(updateId, newStatus);
                    break;

                case 5:
                    System.out.println("Exiting. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }

        } while (choice != 5);

        sc.close();
    }
}
