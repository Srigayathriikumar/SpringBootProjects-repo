package services;
import models.*;
import exceptions.*;
public class UserService {
    public void registerUser(User user) throws InvalidAgeExceptions{
        if(user.getAge()<18){
            throw new InvalidAgeExceptions("The user "+user.getUsername()+" must be above the age of 18\n");
        }
       
            System.out.println("The user " +user.getUsername()+" Resgistered successfully !!\n");
        

    }
}
