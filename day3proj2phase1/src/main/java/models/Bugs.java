package models;
import interfaces.Reportable;
public class Bugs extends Issue implements Reportable {
    public String priority;
    public String status;
    public Bugs(String issueid, String issuetitle, String issuedesc, String priority, String status) {
        super(issueid, issuetitle, issuedesc);
        this.priority = priority;
        this.status = status;
    }
    public String getPriority() {
        return priority;
    }
    public String getStatus() {
        return status;
    }
    @Override
    public void displayissuedetails(){
        System.out.println("Bug Issue ID: " + getIssueid());
        System.out.println("Title: " + getIssuetitle());
        System.out.println("Description: " + getIssuedesc());
        System.out.println("Priority: " + getPriority());
        System.out.println("Status: " + getStatus());
        System.out.println();
    }
    @Override
    public void reportissue(){
        System.out.println("Reporting Bug ID " + getIssueid() + "has Priority NO" + getPriority() + ". The present Status of this bug is " + getStatus());
        System.out.println();
    }

    @Override
    public void reportStatus() {
        System.out.println("Bug Status: " + getStatus());
    }
    
}
