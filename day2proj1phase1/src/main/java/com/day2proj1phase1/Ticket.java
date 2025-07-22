package com.day2proj1phase1;

public class Ticket {
    //properties
    private int ticketid;
    private String title;
    private String status;

    //constructor
    public Ticket(int ticketid,String title){
        this.ticketid=ticketid;
        this.title=title;
        this.status="Open";
    }

    public int getticketId(){
        return ticketid;
    }

    public String getTitle() {
        return title;
    }

    public String getStatus() {
        return status;
    }

    public void displayticketdetails(){
        System.out.println("Displaying the ticket details");
        System.out.println("ticket id: "+ticketid);
        System.out.println("ticket title: "+title);
        System.out.println("ticket status: "+status);
        System.out.println();
    }

    public void closeticket(){
            this.status="Closed";
            System.out.println("Ticket closed Successfully");
    }
}
