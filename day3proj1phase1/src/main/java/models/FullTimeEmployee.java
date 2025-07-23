package models;

import interfaces.Taxable;

public class FullTimeEmployee extends Employee implements Taxable {
    public int salary;
    public FullTimeEmployee(String name, int salary) {
        super(name);
        this.salary = salary;
    }
    @Override
    public double calculatesalary() {
       return salary;
    }
    @Override
    public void calculatetax() {    
        System.out.println("Full Time Employee: "+getName()+"'s tax: "+salary * 0.2);
        System.out.println("Full Time Employee: " + getName() + " 's Final salary: " + (salary -(salary * 0.2)));
         System.out.println();
}
}
