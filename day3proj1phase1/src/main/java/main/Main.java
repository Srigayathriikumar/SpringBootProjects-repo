package main;

import models.FullTimeEmployee;
import models.PartTimeEmployee;
import interfaces.Taxable;
import java.util.*;


public class Main {
    public static void main(String[] args){
        List<Taxable> employees=new ArrayList<>();

        employees.add(new FullTimeEmployee("John",10000));
        employees.add(new FullTimeEmployee("Watson",15000));
        employees.add(new FullTimeEmployee("Max",15700));
        employees.add(new FullTimeEmployee("Alex",12500));
        employees.add(new FullTimeEmployee("Harry",25000));
        employees.add(new PartTimeEmployee("Florida",12,100.00));
        employees.add(new PartTimeEmployee("Lily", 20, 100.00));
        employees.add(new PartTimeEmployee("Venisa", 27, 300.00));
        employees.add(new PartTimeEmployee("Jack", 50, 200.00));
        employees.add(new PartTimeEmployee("Swathi", 35, 150.00));
        for(Taxable emp:employees){
            emp.calculatetax();
        }
        
    }
}
