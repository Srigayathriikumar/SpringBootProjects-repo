package main;
import models.*;
import java.io.*;
import java.time.LocalDateTime;
import services.TicketService;
import java.util.*;

import exceptions.MissingFieldException;
public class Main {
    public static void main(String[] args) throws Exception{
    Scanner s=new Scanner(System.in);
    TicketService excep=new TicketService();
    List<Ticket> ticketlist=new ArrayList<>();
    boolean check=true;
    while(check){
        System.out.println("MENU:\n1.Add Ticket\n2.List Ticket\n3.Exit\nEnter your Option: ");
        int option=s.nextInt();
        switch(option){
            case 1:
            System.out.println("Enter username: ");
            String name=s.next();
            s.nextLine();
            System.out.println("Enter Age: ");
            int age=s.nextInt();
            s.nextLine();
            System.out.println("Enter Source: ");
            String source=s.nextLine();
            System.out.println("Enter Destination: ");
            String dest=s.nextLine();
            s.nextLine();
            User usr1=new User(name,age);
            Ticket tct1=new Ticket(source,dest,usr1);
            try{
            if(excep.Reportissue(tct1)){
            ticketlist.add(tct1);
            System.out.print(name);
            System.out.println("'s Ticket is Reserved Successfully !!");
            }

            }
            
            catch(MissingFieldException e){
                logError(LocalDateTime.now()+e.getMessage());
                System.out.println(e.getMessage());
            }
            break;
            case 2:
            System.out.println("The List of existing tickets are:");
            for(Ticket tct:ticketlist){
                tct.tctdisplayDetails();
            }
            break;
            case 3:
            System.out.println("-------------QUIT--------------");
            return;
            default:
            System.out.println("Invalid Input");
        }
        
    
    }
    }
public static void logError(String message) throws Exception{
    try(BufferedWriter writer=new BufferedWriter(new FileWriter("error.log",true))){
        writer.write(message);
    }
    catch(Exception e){
        System.out.println("Cannot write into the log file!!"+e.getMessage());
    }
}
}

