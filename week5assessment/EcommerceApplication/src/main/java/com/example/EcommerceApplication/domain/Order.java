package com.example.EcommerceApplication.domain;

import java.util.Date;

import jakarta.persistence.*;


@Entity
@Table(name = "orders")
public class Order {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private Date orderdate;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private String status;



    
    public Order() {
    }
    public Order(Long id, Date orderdate, User user, String status) {
        this.id = id;
        this.orderdate = orderdate;
        this.user = user;
        this.status = status;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
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
