package com.example.HelpDeskORM.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.example.HelpDeskORM.domain.SupportTicket;
import com.example.HelpDeskORM.util.DBUtil;

public class SupportTicketRepositoryImpl implements SupportTicketRepository {
    
    @Override
    public void createSupportTicket(SupportTicket supportTicket) {
       Connection conn = DBUtil.getConnection();
       try{
        PreparedStatement ps = conn.prepareStatement("insert into support_ticket (ticket_Id,description,status,created_by,assigned_to) values (?, ?, ?, ?,?)");
        ps.setLong(1, supportTicket.getTicketId());
        ps.setString(2, supportTicket.getDescription());
        ps.setString(3, supportTicket.getStatus());
        ps.setString(4, supportTicket.getCreated_by());
        ps.setString(5, supportTicket.getAssigned_to());
        ps.executeUpdate();


       }catch(Exception e){
           e.printStackTrace();
       }
}
    @Override
    public List<SupportTicket> getAllTickets() {
       Connection conn = DBUtil.getConnection();
       List<SupportTicket> tickets = new ArrayList<>();
         try {
              PreparedStatement ps = conn.prepareStatement("SELECT * FROM support_ticket");
              ResultSet rs = ps.executeQuery();
              while (rs.next()) {
                SupportTicket ticket = new SupportTicket();
                ticket.setTicketId(rs.getLong("ticket_Id"));
                ticket.setDescription(rs.getString("description"));
                ticket.setStatus(rs.getString("status"));
                ticket.setCreated_by(rs.getString("created_by"));
                ticket.setAssigned_to(rs.getString("assigned_to"));
                tickets.add(ticket);
              }
         } catch (Exception e) {
              e.printStackTrace();
         }
         return tickets;
    }
    @Override
    public void setticketstatus(long ticketid) {
        Connection conn = DBUtil.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("UPDATE support_ticket SET status = ? WHERE ticket_Id = ?");
            ps.setString(1, "Resolved"); 
            ps.setLong(2, ticketid);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void assignticket(long ticketid, String assignedTo) {
        Connection conn = DBUtil.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("UPDATE support_ticket SET assigned_to = ? WHERE ticket_Id = ?");
            ps.setString(1, assignedTo);
            ps.setLong(2, ticketid);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
