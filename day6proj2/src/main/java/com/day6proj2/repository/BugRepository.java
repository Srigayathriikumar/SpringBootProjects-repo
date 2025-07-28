package com.day6proj2.repository;

import com.day6proj2.entity.Bug;
import java.util.List;

public interface BugRepository {
    void createBug(Bug bug);
    List<Bug> getAllBugs();
    void updateBug(Bug bug);
    void deleteBug(Bug bug);
}
