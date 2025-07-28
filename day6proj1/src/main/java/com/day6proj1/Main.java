package com.day6proj1;
import com.day6proj1.controller.BugController;
import com.day6proj1.repository.BugRepository;  
import com.day6proj1.repository.BugRepositoryImpl;
import com.day6proj1.services.BugService;
public class Main {
    public static void main(String[] args){
        BugRepository bugrepo = new BugRepositoryImpl(); 
        BugService bugservice = new BugService(bugrepo);
        BugController con= new BugController(bugservice);
        con.run();
    }
}
