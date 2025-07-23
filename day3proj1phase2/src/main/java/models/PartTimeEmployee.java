package models;
public class PartTimeEmployee extends Employee {
    private double hourrate;
    private int hours;

    public PartTimeEmployee(String name, int hours,String dept, double hourrate) {
        super(name,dept);
        this.hourrate =hourrate;
        this.hours = hours;
    }
    @Override
    public double calculatesalary() {   
        return (hourrate * hours)*0.1;
    }
    @Override
    public void displayDetails() {
        double salary = hourrate * hours;
        double tax = salary * 0.1; 
        System.out.println("["+getId()+"] "+"PartTime - "+getName()+"| Dept: "+getDept()+" |Salary:₹ "+salary+" |Tax:₹ "+tax);
    }
    }
    

