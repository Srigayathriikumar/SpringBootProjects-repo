package com.day2proj2phase1;

public class User {
  public int userid;
  public String username;
  public String useremail;
  
  public User(int userid,String username,String useremail){
    this.userid=userid;
    this.username=username;
    this.useremail=useremail;
  }

  public int getUserid() {
    return userid;
  }

  public String getUsername() {
    return username;
  }

  public String getUseremail() {
    return useremail;
  }
  public void displayuserdetails(){
        System.out.println("User details");
        System.out.println("user id: "+userid);
        System.out.println("user name: "+username);
        System.out.println("user email: "+useremail);
        System.out.println("------------------");
    }
}
