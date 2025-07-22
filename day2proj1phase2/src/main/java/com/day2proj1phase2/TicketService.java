package com.day2proj1phase2;

import java.util.ArrayList;
import java.util.List;

public class TicketService {
    private List<Ticket> ticketlist;
    public TicketService(){
        ticketlist=new ArrayList<>();
    }
    public void addTicket(Ticket ticket){
        ticketlist.add(ticket);
    }
    public void displayalltickets(){
        System.out.println("Displaying the list of tickets");
        if(ticketlist.isEmpty()){
            System.out.println("There is no Ticket in the list");
        }
        else{
        for(Ticket tick:ticketlist){
            tick.displayticketdetails();
        }
    }
    }
}
