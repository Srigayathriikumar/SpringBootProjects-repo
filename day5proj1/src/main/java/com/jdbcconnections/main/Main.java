package com.jdbcconnections.main;
import java.util.Scanner;
import java.util.List;
import com.jdbcconnections.dao.BugDAO;
import com.jdbcconnections.models.Bug;
public class Main {
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        BugDAO dao=new BugDAO();
        System.out.println("Enter the Title,Description and Status in order:");
        String title=s.nextLine();
        String description=s.nextLine();
        String status=s.next();
        dao.insertbug(new Bug(title,description,status));
        List<Bug> displist=dao.getallbugs();
        for(Bug b:displist){
            System.out.println("Bug ID: "+b.getId());
            System.out.println("Bug Title: "+b.getTitle());
            System.out.println("Bug Description: "+b.getDescription());           
            System.out.println("Bug Status: "+b.getStatus());
            System.out.println("----------------------------");

        }
    }
}
