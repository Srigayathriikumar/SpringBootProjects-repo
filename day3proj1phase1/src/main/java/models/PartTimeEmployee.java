package models;

import interfaces.Taxable;

public class PartTimeEmployee extends Employee implements Taxable{
    public int hours;
    public double rateperhour;
    public PartTimeEmployee(String name,int hours, double rateperhour) {
        super(name);
        this.hours = hours;
        this.rateperhour = rateperhour;
    }
    @Override
    public double calculatesalary(){
        double hrs=(double)hours;
        return hrs*rateperhour;
    }
    @Override
    public void calculatetax(){
        double sal=calculatesalary();
        System.out.println("The PartTime Employee "+getName()+"'s Tax: "+ sal*0.1);
        System.out.println("The PartTime Employee "+getName()+"'s Salary: "+ (sal-(sal*0.1)));
        System.out.println();
    }
}
