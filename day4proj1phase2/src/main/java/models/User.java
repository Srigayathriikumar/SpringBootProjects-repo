package models;

public class User {
    public String username;
    public int age;
    public User(String username, int age) {
        this.username = username;
        this.age = age;
    }
    public String getUsername() {
        return username;
    }
    public int getAge() {
        return age;
    }
    
}
