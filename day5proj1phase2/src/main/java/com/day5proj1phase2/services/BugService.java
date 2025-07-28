package com.day5proj1phase2.services;

import com.day5proj1phase2.dao.BugDAO;
import com.day5proj1phase2.models.Bug;

import java.util.List;

public class BugService {
    private BugDAO bugDAO = new BugDAO();

    public void addBug(Bug bug) {
        bugDAO.insertBug(bug);
    }

    public List<Bug> viewAllBugs() {
        return bugDAO.getAllBugs();
    }

    public void deleteBug(int id) {
        bugDAO.deleteBugById(id);
    }

    public void updateBugStatus(int id, String status) {
        bugDAO.updateBugStatus(id, status);
    }
}

