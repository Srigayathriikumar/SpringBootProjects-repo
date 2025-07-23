package com.day2proj2phase1;

public class Ticket {
    //properties
    private int ticketid;
    private String title;
    private String description;
    private String status;
    private User user;

    //constructor
    public Ticket(int ticketid,String title,String description,User user){
        this.ticketid=ticketid;
        this.title=title;
        this.description=description;
        this.status="Open";
        this.user=user;

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

    public String getDescription() {
        return description;
    }

    public void displayticketdetails(){
        System.out.println("Ticket details");
        System.out.println("ticket id: "+ticketid);
        System.out.println("ticket title: "+title);
        System.out.println("ticket description: "+description);
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

