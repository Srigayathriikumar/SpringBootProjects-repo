package models;

public abstract class Employee {
    public String name; 
    public Employee(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public abstract double calculatesalary();
}
