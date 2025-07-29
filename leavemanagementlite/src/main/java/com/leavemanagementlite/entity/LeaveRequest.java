package com.leavemanagementlite.entity;

import java.time.LocalDate;

public class LeaveRequest {
    private int id;
    private int employeeId;
    private LocalDate fromDate;
    private LocalDate toDate;
    private String reason;
    private String status;

    public LeaveRequest(int id, int employeeId, LocalDate fromDate, LocalDate toDate, String reason, String status) {
        this.id = id;
        this.employeeId = employeeId;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.reason = reason;
        this.status = status;
    }

    // Getters and Setters
    public int getId() { return id; }
    public int getEmployeeId() { return employeeId; }
    public LocalDate getFromDate() { return fromDate; }
    public LocalDate getToDate() { return toDate; }
    public String getReason() { return reason; }
    public String getStatus() { return status; }
}
