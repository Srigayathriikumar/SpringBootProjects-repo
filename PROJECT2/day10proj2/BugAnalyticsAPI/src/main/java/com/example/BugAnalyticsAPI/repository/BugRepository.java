package com.example.BugAnalyticsAPI.repository;
import org.springframework.stereotype.Repository;

import com.example.BugAnalyticsAPI.dto.PriorityCountDTO;
import com.example.BugAnalyticsAPI.dto.ProjectBugCountDTO;
import com.example.BugAnalyticsAPI.dto.StatusCountDTO;
import com.example.BugAnalyticsAPI.entity.Bug;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.*;
@Repository

public interface BugRepository extends JpaRepository<Bug, Long> {

    @Query("SELECT b FROM Bug b")
     List<Bug> findAllBugs();

    @Query("SELECT new com.example.BugAnalyticsAPI.dto.ProjectBugCountDTO(b.project.id, COUNT(b)) FROM Bug b WHERE b.project.id IS NOT NULL GROUP BY b.project.id")
    List<ProjectBugCountDTO> countBugsByProject();

    @Query("SELECT new com.example.BugAnalyticsAPI.dto.StatusCountDTO(b.status, COUNT(b)) FROM Bug b GROUP BY b.status")
    List<StatusCountDTO> countBugsByStatus();

    @Query("SELECT new com.example.BugAnalyticsAPI.dto.PriorityCountDTO(b.priority, COUNT(b)) FROM Bug b WHERE b.priority IS NOT NULL GROUP BY b.priority")
    List<PriorityCountDTO> countBugsByPriority();

    @Query("SELECT new com.example.BugAnalyticsAPI.dto.ProjectBugCountDTO(b.project.id, COUNT(b)) FROM Bug b WHERE b.project.id IS NOT NULL GROUP BY b.project.id ORDER BY COUNT(b) DESC")
List<ProjectBugCountDTO> findTop3ProjectsWithMostBugs(org.springframework.data.domain.Pageable pageable);

    @Query("SELECT COUNT(b) FROM Bug b WHERE b.project.id = :projectId")
    Long countBugsByProjectId(Long projectId);

    Long countBugsByProjectName(String projectName);


}
