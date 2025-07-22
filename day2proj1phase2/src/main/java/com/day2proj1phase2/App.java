package com.day2proj1phase2;

public class App{
    public static void main(String[] args){
       User usr1=new User(123,"john","john123@gmail.com");
    User usr2=new User(124,"lily","lily124@gmail.com");
        Ticket tct1=new Ticket(001,"wrong transaction",usr1);
        Ticket tct2=new Ticket(002,"user access request",usr2);
        Ticket tct3=new Ticket(003,"balance checking",usr1);
        TicketService ticklist=new TicketService();
        ticklist.addTicket(tct1);
        ticklist.addTicket(tct2);
        ticklist.addTicket(tct3);
        ticklist.displayalltickets();
        tct2.closeticket(tct1.getticketId());
        ticklist.displayalltickets();
    }
}
