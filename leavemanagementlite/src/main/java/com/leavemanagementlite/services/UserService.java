package com.leavemanagementlite.services;

import com.leavemanagementlite.dao.UserDAO;
import com.leavemanagementlite.entity.Employee;
import com.leavemanagementlite.entity.LeaveRequest;
import com.leavemanagementlite.exceptions.InvalidLeaveDateException;

import java.time.LocalDate;

public class UserService {
    private final UserDAO dao = new UserDAO();

    public void addEmployee(Employee emp) {
        dao.insertemployee(emp);
    }

    public void applyLeave(LeaveRequest req) throws InvalidLeaveDateException {
        if (req.getFromDate().isAfter(req.getToDate())) {
            throw new InvalidLeaveDateException("From-date is after to-date!");
        }
        dao.insertleave(req);
    }

    public void updatestatus(int leaveId, String status) {
        if(status == null || (!status.equalsIgnoreCase("Approved") && !status.equalsIgnoreCase("Rejected"))) {
            throw new IllegalArgumentException("Invalid status. Use 'Approved' or 'Rejected'.");
        }
        dao.updatestatus(leaveId, status);}

    public void deleteleave(int leaveId) {
        if(leaveId <= 0) {
            throw new IllegalArgumentException("Leave ID must be positive.");
        }
        dao.deleteleave(leaveId);
    }

    public void displayallemployees() {
        if(dao == null) {
            throw new IllegalStateException("DAO is not initialized.");
        }
        dao.displayallemployees();
    }

    public void displayallleaverequests() {
        if(dao == null) {
            throw new IllegalStateException("DAO is not initialized.");
        }
        dao.displayallleaverequests();
}
}