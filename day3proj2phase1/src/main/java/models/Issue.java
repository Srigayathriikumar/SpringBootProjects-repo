package models;

public abstract class Issue {
    public String issueid;
    public String issuetitle;
    public String issuedesc;
    public Issue(String issueid, String issuetitle, String issuedesc) {
        this.issueid = issueid;
        this.issuetitle = issuetitle;
        this.issuedesc = issuedesc;
    }
    public String getIssueid() {
        return issueid;
    }
    public String getIssuetitle() {
        return issuetitle;
    }
    public String getIssuedesc() {
        return issuedesc;
    }
    public abstract void displayissuedetails();
}
