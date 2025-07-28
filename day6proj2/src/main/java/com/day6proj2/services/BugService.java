package com.day6proj2.services;
import com.day6proj2.entity.Bug;
import com.day6proj2.repository.BugRepository;

import java.util.List;

public class BugService {
    private BugRepository repository;

    public BugService(BugRepository repository) {
        this.repository = repository;
    }

    public void createBug(String title, String description, String status) {
        Bug bug = new Bug(title, description, status);
        repository.createBug(bug);
    }

    public List<Bug> getAllBugs() {
        return repository.getAllBugs();
    }
    public void updateBug(Bug bug) {
        repository.updateBug(bug);
    }
    public void deleteBug(Bug bug) {
        repository.deleteBug(bug);
    }

    public Bug getBugById(int id) {
        List<Bug> bugs = repository.getAllBugs();
        for (Bug bug : bugs) {
            if (bug.getId() == id) {
                return bug;
            }
        }
        return null; 
    }
}
