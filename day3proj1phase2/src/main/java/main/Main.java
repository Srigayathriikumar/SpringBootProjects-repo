package main;
import models.Employee;
import models.FullTimeEmployee;
import models.PartTimeEmployee;
import models.TaxReportGenerator;
import java.util.*;
public class Main{
      public static void main(String[] args){
        List<Employee> employees=new ArrayList<>();
        TaxReportGenerator emp=new TaxReportGenerator();
        employees.add(new FullTimeEmployee("John","HR",10000));
        employees.add(new FullTimeEmployee("Watson","DEV",15000));
        employees.add(new FullTimeEmployee("Max","DEV",15700));
        employees.add(new FullTimeEmployee("Alex","TEST",12500));
        employees.add(new FullTimeEmployee("Harry","HR",25000));
        employees.add(new PartTimeEmployee("Florida",12,"SUPPORT",100.00));
        employees.add(new PartTimeEmployee("Lily", 20,"SUPPORT", 100.00));
        employees.add(new PartTimeEmployee("Venisa", 27,"DEV", 300.00));
        employees.add(new PartTimeEmployee("Jack", 50,"TEST", 200.00));
        employees.add(new PartTimeEmployee("Swathi",35,"AI", 150.00));
        emp.sortbytaxbydecending(employees);
        emp.displayallemployees(employees);
        emp.totaltax(employees);
        emp.groupbydept(employees);
    }
}