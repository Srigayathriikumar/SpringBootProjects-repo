package services;

import exceptions.MissingFieldException;
import models.*;
public class TicketService{
    public boolean Reportissue(Ticket ticket) throws MissingFieldException{
        boolean res=true;
        if(ticket.getSource().isEmpty() || ticket.getDest().isEmpty()){
            throw new MissingFieldException("The source and Destination fields are mandatory to fill\n");
        }
        System.out.println("The Ticket "+ticket.getTicketid()+" is reserved successfully\n");
        return res;
    }
}
