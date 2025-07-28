package com.day5proj1phase2.dao;
import com.day5proj1phase2.models.Bug;
import com.day5proj1phase2.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BugDAO {

    public void insertBug(Bug bug) {
        String sql = "INSERT INTO bugs (title, description, status) VALUES (?, ?, ?)";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, bug.getTitle());
            stmt.setString(2, bug.getDescription());
            stmt.setString(3, bug.getStatus());
            stmt.executeUpdate();

            System.out.println("✅ Bug inserted successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Bug> getAllBugs() {
        List<Bug> bugs = new ArrayList<>();
        String sql = "SELECT * FROM bugs";

        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Bug bug = new Bug(
                    rs.getInt("id"),
                    rs.getString("title"),
                    rs.getString("description"),
                    rs.getString("status")
                );
                bugs.add(bug);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bugs;
    }

    public void deleteBugById(int id) {
        String sql = "DELETE FROM bugs WHERE id = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int rows = stmt.executeUpdate();

            if (rows > 0) System.out.println(" Bug deleted.");
            else System.out.println("Bug ID not found.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateBugStatus(int id, String status) {
        String sql = "UPDATE bugs SET status = ? WHERE id = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, status);
            stmt.setInt(2, id);
            int rows = stmt.executeUpdate();

            if (rows > 0) System.out.println("Status updated.");
            else System.out.println("Bug ID not found.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

