package com.day6proj2.repository;


import com.day6proj2.entity.Bug;
import com.day6proj2.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BugRepositoryImpl implements BugRepository {

    @Override
    public void createBug(Bug bug) {
        Connection con = DBUtil.getConnection();
        try  {
            PreparedStatement ps = con.prepareStatement("INSERT INTO bugs (title, description, status) VALUES (?, ?, ?)");
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
        Connection con = DBUtil.getConnection();
        try  {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM bugs");
            ResultSet rs = ps.executeQuery();
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

    @Override
    public void updateBug(Bug bug) {
        Connection con = DBUtil.getConnection();
        try  {
            PreparedStatement ps = con.prepareStatement("UPDATE bugs SET status = ? WHERE id = ?");
            ps.setString(1, bug.getStatus());
            ps.setInt(2, bug.getId());
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

    @Override
    public void deleteBug(Bug bug) {
        Connection con = DBUtil.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement("DELETE FROM bugs WHERE id = ?");
            ps.setInt(1, bug.getId());
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
