package models;
import interfaces.Taxable;
public class PartTimeEmployee extends Employee implements Taxable {
    private int hours;
    private double hourrate;
    public PartTimeEmployee(String name, int hours, double hourrate) {
        super(name);
        this.hours = hours;
        this.hourrate = hourrate;
    }
    @Override
    public double calculatesalary() {
        double hr = (double) hours;
       return hr * hourrate;
    }
    @Override
    public void calculatetax() {
        double salary = calculatesalary();
        System.out.println("Part Time Employee: " + getName() + "'s tax: " + salary * 0.1);
        System.out.println("Part Time Employee: " + getName() + " 's Final salary: " + (salary - (salary * 0.1)));
        System.out.println();
    }
    
}
