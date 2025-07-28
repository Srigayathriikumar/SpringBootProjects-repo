package com.day6proj2;

import com.day6proj2.controller.BugController;
import com.day6proj2.repository.BugRepository;  
import com.day6proj2.repository.BugRepositoryImpl;
import com.day6proj2.services.BugService;
public class Main {
    public static void main(String[] args){
        BugRepository bugrepo = new BugRepositoryImpl(); 
        BugService bugservice = new BugService(bugrepo);
        BugController con= new BugController(bugservice);
        con.run();
    }
}
