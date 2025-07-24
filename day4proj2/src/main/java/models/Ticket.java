package models;

public class Ticket{
    public static int counter=100;
    private int ticketid;
    private  String source;
    private String dest;
    private User user;
    public Ticket(String source, String dest,User user) {
        
        this.ticketid=counter++;
        this.source = source;
        this.dest = dest;
        this.user=user;
    }
    
    public User getUser() {
        return user;
    }
    public String usrname(){
        return user.getName();
    }

    public int getTicketid() {
        return ticketid;
    }
    public String getSource() {
        return source;
    }
    public String getDest() {
        return dest;
    }
    public void tctdisplayDetails(){
        user.displayDetails();
        System.out.println(ticketid+" "+source+" "+dest);
    }
    
    
}
