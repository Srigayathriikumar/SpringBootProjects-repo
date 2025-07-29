package com.leavemanagementlite.entity;

public class Employee {
    private int id;
    private String name;
    private String department;
    private String email;

    public Employee(int id, String name, String department, String email) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.email = email;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public String getDepartment() { return department; }
    public String getEmail() { return email; }
}
