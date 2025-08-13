package com.example.BugTrackerApplication.repository;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.BugTrackerApplication.dto.BugResponseDTO;
import com.example.BugTrackerApplication.entity.Bug;

public interface BugRepository extends JpaRepository<Bug, Long> {
  
    // @Query("SELECT new com.example.BugTrackerApplication.dto.BugResponseDTO(b.id,b.title, b.status, b.assignee, b.project) " +
    //    "FROM Bug b " +
    //    "WHERE (:status IS NULL OR LOWER(b.status) = LOWER(:status)) " +
    //    "AND (:title IS NULL OR LOWER(b.title) = LOWER(:title))"+
    //    "AND (:assignee IS NULL OR LOWER(b.assignee) = LOWER(:assignee)) " +
    //    "AND (:project IS NULL OR LOWER(b.project) = LOWER(:project))")

@Query("SELECT b FROM Bug b WHERE " +
       "(:title IS NULL OR LOWER(b.title) LIKE LOWER(CONCAT('%', :title, '%'))) AND " +
       "(:status IS NULL OR LOWER(b.status) = LOWER(:status)) AND " +
       "(:assignee IS NULL OR LOWER(b.assignee) = LOWER(:assignee)) AND " +
       "(:project IS NULL OR LOWER(b.project) = LOWER(:project))")
Page<Bug> searchFilteredBugs(
    @Param("title") String title,
    @Param("status") String status,
    @Param("assignee") String assignee,
    @Param("project") String project,
    org.springframework.data.domain.Pageable pageable);

}