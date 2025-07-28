package com.day6proj1.repository;

import com.day6proj1.entity.Bug;
import java.util.List;

public interface BugRepository {
    void createBug(Bug bug);
    List<Bug> getAllBugs();
}
