package models;
import interfaces.Reportable;
public class Task extends Issue implements Reportable {
    public String assignee;
    public String dueDate;

    public Task(String issueid, String issuetitle, String issuedesc, String assignee, String dueDate) {
        super(issueid, issuetitle, issuedesc);
        this.assignee = assignee;
        this.dueDate = dueDate;
}
    public String getAssignee() {
        return assignee;
    }

    public String getDueDate() {
        return dueDate;
    }

    @Override
    public void displayissuedetails() {
        System.out.println("Task Issue ID: " + getIssueid());
        System.out.println("Title: " + getIssuetitle());
        System.out.println("Description: " + getIssuedesc());
        System.out.println("Assignee: " + getAssignee());
        System.out.println("Due Date: " + getDueDate());
        System.out.println();
    }

    @Override
    public void reportissue() {
        System.out.println("Reporting Task ID " + getIssueid() + " assigned to " + getAssignee() + ". Due on " + getDueDate());
        System.out.println();
    }

    @Override
    public void reportStatus() {
        System.out.println("Status of Task ID " + getIssueid() + ": Assigned to " + getAssignee() + ", Due on " + getDueDate());
        System.out.println();
    }
}
