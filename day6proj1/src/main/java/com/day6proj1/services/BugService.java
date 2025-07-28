package com.day6proj1.services;

import com.day6proj1.entity.Bug;
import com.day6proj1.repository.BugRepository;

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
}
