package com.day2proj1phase2;
public class Ticket {
    //properties
    private int ticketid;
    private String title;
    private String status;
    private User user;

    //constructor
    public Ticket(int ticketid,String title,User user){
        this.ticketid=ticketid;
        this.title=title;
        this.user=user;
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
        System.out.println("Ticket details");
        System.out.println("ticket id: "+ticketid);
        System.out.println("ticket title: "+title);
        System.out.println("ticket status: "+status);
        System.out.println();
        user.displayuserdetails();
        System.out.println();

    }

    public void closeticket(int ticketid){
            this.status="Closed";
            System.out.println("Ticket "+ticketid+" closed Successfully\n");
    }
}
