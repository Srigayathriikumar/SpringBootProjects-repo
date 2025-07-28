package com.day5proj1phase2.dao;

import java.sql.*;
import java.util.*;
import com.day5proj1phase2.util.DBUtil;
import com.day5proj1phase2.models.Bug;

public class BugDAO {

    public void insertbug(Bug bug) {
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement("INSERT INTO bugs (title, description, status) VALUES (?, ?, ?)")) {
            ps.setString(1, bug.getTitle());
            ps.setString(2, bug.getDescription());
            ps.setString(3, bug.getStatus());
            ps.executeUpdate();
            System.out.println("Bug inserted successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Bug> getallbugs() {
        List<Bug> list = new ArrayList<>();
        try (Connection con = DBUtil.getConnection();
             PreparedStatement st = con.prepareStatement("SELECT * FROM bugs");
             ResultSet rs = st.executeQuery()) {
            while (rs.next()) {
                Bug b = new Bug();
                b.setId(rs.getInt("id"));
                b.setTitle(rs.getString("title"));
                b.setDescription(rs.getString("description"));
                b.setStatus(rs.getString("status"));
                list.add(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void updateStatus(int id, String newStatus) {
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement("UPDATE bugs SET status = ? WHERE id = ?")) {
            ps.setString(1, newStatus);
            ps.setInt(2, id);
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println(" Status updated successfully.");
            } else {
                System.out.println(" Bug ID not found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteBug(int id) {
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement("DELETE FROM bugs WHERE id = ?")) {
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Bug deleted successfully.");
            } else {
                System.out.println(" Bug ID not found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
