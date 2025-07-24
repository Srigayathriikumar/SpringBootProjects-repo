package services;

import exceptions.InvalidAgeException;
import models.*;
public class UserService  {
    public void registerUser(User user) throws InvalidAgeException{
        if(user.getAge()<18){
            throw new InvalidAgeException("The User "+user.getUsername()+" of age "+user.getAge()+" cannot register in this portal as he is below 18 years old.\n");
            
        }
        System.out.println("The User "+user.getUsername()+" Registered Successfully !! \n");
    }
}
