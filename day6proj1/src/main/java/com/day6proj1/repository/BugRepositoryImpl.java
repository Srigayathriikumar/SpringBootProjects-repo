package com.day6proj1.repository;

import com.day6proj1.entity.Bug;
import com.day6proj1.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BugRepositoryImpl implements BugRepository {

    @Override
    public void createBug(Bug bug) {
        
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement("INSERT INTO bugs(title, description, status) VALUES (?, ?, ?)")) {
            ps.setString(1, bug.getTitle());
            ps.setString(2, bug.getDescription());
            ps.setString(3, bug.getStatus());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Bug> getAllBugs() {
        List<Bug> bugList = new ArrayList<>();
        
        try (Connection con = DBUtil.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM bugs")) {
            while (rs.next()) {
                Bug bug = new Bug();
                bug.setId(rs.getInt("id"));
                bug.setTitle(rs.getString("title"));
                bug.setDescription(rs.getString("description"));
                bug.setStatus(rs.getString("status"));
                bugList.add(bug);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bugList;
    }
}
