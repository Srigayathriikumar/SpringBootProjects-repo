package com.day2proj1phase2;

public class User {
    public int id;
    public String name;
    public String email;

    public User(int id,String name,String email){
        this.id=id;
        this.name=name;
        this.email=email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
     public void displayuserdetails(){
        System.out.println("User details");
        System.out.println("user id: "+id);
        System.out.println("user name: "+name);
        System.out.println("user email: "+email);
        System.out.println("------------------");
    }
    
}