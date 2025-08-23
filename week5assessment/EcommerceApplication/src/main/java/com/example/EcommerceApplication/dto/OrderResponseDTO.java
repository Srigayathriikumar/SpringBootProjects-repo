package com.example.EcommerceApplication.dto;
import java.util.*;
import com.example.EcommerceApplication.domain.User;
public class OrderResponseDTO {
    
    private Long id;
    private Date orderdate;
    private User user;
    private String status;

    
     public OrderResponseDTO() {
    }

     public OrderResponseDTO(Long id,Date orderdate, User user, String status) {
        this.id = id;
        this.orderdate = orderdate;
        this.user = user;
        this.status = status;
    }

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }
     public Date getOrderdate() {
         return orderdate;
     }

     public void setOrderdate(Date orderdate) {
         this.orderdate = orderdate;
     }

     public User getUser() {
         return user;
     }

     public void setUser(User user) {
         this.user = user;
     }

     public String getStatus() {
         return status;
     }

     public void setStatus(String status) {
         this.status = status;
     }
    
}
