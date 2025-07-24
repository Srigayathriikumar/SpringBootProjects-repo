package main;
import java.util.*;
import exceptions.InvalidAgeExceptions;
import services.UserService;
import models.*;
public class Main {
    public static void main(String[] args){
    UserService excep=new UserService();
    List<User> userlist=new ArrayList<>();
    userlist.add(new User("John",28));
    userlist.add(new User("Will",15));
    userlist.add(new User("Lily",21));
    userlist.add(new User("Max",13));
    
        for(User user:userlist){
            try{
                excep.registerUser(user);
            }
            catch(InvalidAgeExceptions e){
                System.out.println(e.getMessage());
            }
        }
    
    }
}
