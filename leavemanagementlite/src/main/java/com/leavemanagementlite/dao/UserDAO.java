package com.leavemanagementlite.dao;

import com.leavemanagementlite.entity.Employee;
import com.leavemanagementlite.entity.LeaveRequest;
import com.leavemanagementlite.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
public class UserDAO {

    public void insertemployee(Employee emp) {
        Connection conn = DBUtil.getConnection();
        try  {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO employee (name, department, email) VALUES (?, ?, ?)");
            stmt.setString(1, emp.getName());
            stmt.setString(2, emp.getDepartment());
            stmt.setString(3, emp.getEmail());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertleave(LeaveRequest req) {
        Connection conn = DBUtil.getConnection();
        try  {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO leave_request (employee_id, from_date, to_date, reason, status) VALUES (?, ?, ?, ?, ?)");

            stmt.setInt(1, req.getEmployeeId());
            stmt.setDate(2, Date.valueOf(req.getFromDate()));
            stmt.setDate(3, Date.valueOf(req.getToDate()));
            stmt.setString(4, req.getReason());
            stmt.setString(5, req.getStatus());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatestatus(int leaveId, String status) {
        Connection conn = DBUtil.getConnection();
        try{
            PreparedStatement stmt = conn.prepareStatement("UPDATE leave_request SET status = ? WHERE id = ?");

            stmt.setString(1, status);
            stmt.setInt(2, leaveId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteleave(int leaveId) {
        Connection conn = DBUtil.getConnection();
        try {
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM leave_request WHERE id = ?");
            stmt.setInt(1, leaveId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void displayallemployees() {
        Connection conn = DBUtil.getConnection();
        List<Employee> employees = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM employee");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String department = rs.getString("department");
                String email = rs.getString("email");
                employees.add(new Employee(id, name, department, email));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (Employee emp : employees) {
            System.out.println(emp.getId() + " | " + emp.getName() + " | " + emp.getDepartment() + " | " + emp.getEmail());
        }
    }

    public void displayallleaverequests() {
        Connection conn = DBUtil.getConnection();
        List<LeaveRequest> leaveRequests = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM leave_request");
            while (rs.next()) {
                int id = rs.getInt("id");
                int employeeId = rs.getInt("employee_id");
                LocalDate fromDate = rs.getDate("from_date").toLocalDate();
                LocalDate toDate = rs.getDate("to_date").toLocalDate();
                String reason = rs.getString("reason");
                String status = rs.getString("status");
                leaveRequests.add(new LeaveRequest(id, employeeId, fromDate, toDate, reason, status));
            }
        } catch (SQLException e) {
            e.printStackTrace();
}
for(LeaveRequest req : leaveRequests) {
            System.out.println(req.getId() + " | " + req.getEmployeeId() + " | " + req.getFromDate() + " | " + req.getToDate() + " | " + req.getReason() + " | " + req.getStatus());
        }
    }
}
