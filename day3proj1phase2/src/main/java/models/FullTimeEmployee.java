package models;
public class FullTimeEmployee extends Employee{
    public int salary;
    public FullTimeEmployee(String name,String dept,int salary) {
        super(name, dept);
        
        this.salary = salary;
       
    }
    @Override
    public double calculatesalary() {
       return salary*0.2;
    }
    @Override
    public void displayDetails() {
        System.out.println("["+getId()+"] "+"FullTime - "+getName()+"| Dept: "+getDept()+" |Salary:₹ "+getSalary()+" |Tax:₹ "+(salary * 0.2));
    }

    

    public int getSalary() {
        return salary;
    }

}

