package models;
import interfaces.Taxable;

public abstract class Employee implements Taxable{
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public abstract double calculatesalary();

}
