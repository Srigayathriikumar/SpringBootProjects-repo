package com.day2proj1phase1;

public class App{
    public static void main(String[] args){
        User usr1=new User(123,"john","john123@gmail.com");
        usr1.displayuserdetails();
        Ticket tct1=new Ticket(001,"wrong transaction");
        tct1.displayticketdetails();
        tct1.closeticket();
        tct1.displayticketdetails();
    }
}

