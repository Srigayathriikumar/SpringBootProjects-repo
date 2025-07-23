package models;
import java.util.*;
public class TaxReportGenerator{
    
    public void displayallemployees(List<Employee> employees) {
        for(Employee emp:employees){
            emp.displayDetails();
            System.out.println("--------------------------------\n");
        }
    }
    public void sortbytaxbydecending(List<Employee> employees) {
       employees.sort((e1, e2) -> Double.compare(e2.getTax(), e1.getTax()));
    }
    public void totaltax(List<Employee> employees) {
        double totalTax = 0;
        for(Employee emp:employees){
            totalTax += emp.getTax();
        }
        System.out.println("Total Tax Collected:₹ " + totalTax);
        System.out.println();
    }
    public void groupbydept(List<Employee> employees){
        Map<String,List<Employee>> deptmap=new HashMap<>();
        double totaldepttax=0.00;
        for(Employee emp:employees){
            String dep=emp.getDept();
            if(!deptmap.containsKey(dep)){
                deptmap.put(dep, new ArrayList<Employee>());
            }
            deptmap.get(dep).add(emp);
        }
        for(Map.Entry<String,List<Employee>> depemp: deptmap.entrySet()){
            System.out.println("Department: "+depemp.getKey());
            System.out.println("The employees in the department :");
            for(Employee ep:depemp.getValue()){
                System.out.println(ep.getName());
                totaldepttax+=ep.getTax();
            }
            System.out.println("\nTotal department tax:₹ "+totaldepttax);
            System.out.println();
        }
    }
    
}
