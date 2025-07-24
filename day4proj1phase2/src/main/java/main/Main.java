package main;

import java.io.BufferedWriter;
import java.util.Scanner;
import java.io.*;
import exceptions.InvalidAgeException;
import services.UserService;
import models.*;
import java.time.LocalDateTime;
public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        UserService excep=new UserService();
        boolean check=true;
        while(check){
        System.out.println("Enter the username and Age: ");
        String username=sc.nextLine();
        if(username.matches("quit") || username.matches("Quit")){
            System.out.println("-----Quit-----");
            check=false;
            return;
        }
        int age=sc.nextInt();
        sc.nextLine();
        
            User user=new User(username,age);
            try{
                excep.registerUser(user);
            }
            catch(InvalidAgeException e){
                logError(e.getMessage());
                System.out.println(e.getMessage());
            }        
        
       
    
        }   
        sc.close(); 
    }
    public  static void logError(String message){
        try(BufferedWriter writer=new BufferedWriter(new FileWriter("error.log",true))){
            writer.write(LocalDateTime.now()+ message);
        writer.newLine();
        }
        catch(Exception e){
            System.out.println("Cannot Load data to log file"+e.getMessage());
        }
    }
}
