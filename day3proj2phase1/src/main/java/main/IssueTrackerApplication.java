package main;
import java.util.*;
import models.*;
import interfaces.Reportable;
public class IssueTrackerApplication {
    public static void main(String[] args){
    List<Issue> issues = new ArrayList<>();
        issues.add(new Task("T001", "Fix Bug", "There is a bug in the application", "Alice", "2023-10-15"));
        issues.add(new Task("T002", "Implement Feature", "New feature implementation required", "Bob", "2023-10-20"));
        issues.add(new Bugs("B001", "Critical Bug", "Application crashes on startup", "High", "Open"));
        issues.add(new Bugs("B002", "Minor Bug", "UI misalignment on homepage", "Low", "Closed"));
        for (Issue issue : issues) {
            issue.displayissuedetails();
             if (issue instanceof Reportable) {
                Reportable reportable = (Reportable) issue;
                reportable.reportStatus();               
            }
        }
    }
}
