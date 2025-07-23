package models;

import interfaces.Taxable;

public class FullTimeEmployee extends Employee implements Taxable {
    public int salary;

    public FullTimeEmployee(String name, int salary) {
        super(name);
        this.salary = salary;
    }
    @Override
    public double calculatesalary(){
        return salary;
    }
    @Override
    public void calculatetax(){
    System.out.println("The FullTime Employee "+getName()+"'s Tax: "+ salary*0.2);
    System.out.println("The FullTime Employee "+getName()+"'s Salary: "+ (salary-(salary*0.2)));
    System.out.println();

    }
}
