package com.day2proj2phase1;
public class App{
    public static void main(String[] args){
       User usr1=new User(123,"john","john123@gmail.com");
       User usr2=new User(124,"lily","lily124@gmail.com");
        Ticket tct1=new Ticket(001,"wrong transaction","assingned to emp4",usr1);
        Ticket tct2=new Ticket(002,"user access request","assigned to emp1",usr2);
        Ticket tct3=new Ticket(003,"balance checking","assigned to emp3",usr1);
        tct2.closeticket(tct2.getticketId());
        tct1.displayticketdetails();
        tct2.displayticketdetails();
        tct3.displayticketdetails();
    }
}
