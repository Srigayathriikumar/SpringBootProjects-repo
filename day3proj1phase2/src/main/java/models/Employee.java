package models;

public abstract class Employee {
    public static int counter=100;
    public int id;
    public String name;
    public String dept;
    public Employee(String name,String dept) {
        this.name = name;
        this.id = counter++;
        this.dept=dept;
    }
    public String getName() {
        return name;
    }
    public int getId() {
        return id;
    }
    public String getDept() {
        return dept;
    }
    public double getTax(){
        return calculatesalary();
    }
    public abstract double calculatesalary();
    public abstract void displayDetails();
}
