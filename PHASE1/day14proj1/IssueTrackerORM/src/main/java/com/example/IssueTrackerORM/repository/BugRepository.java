package com.example.IssueTrackerORM.repository;
import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.IssueTrackerORM.domain.Bug;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BugRepository extends JpaRepository<Bug, Long> {
    List<Bug> findByStatus(String status);
    //List<Bug> findByPriorityOrderByCreatedDateDesc(String priority);
    List<Bug> findByProject_Id(int project_id);
    List<Bug> findByAssignedToId(int userId);

    @Query("SELECT b FROM Bug b where b.status <> 'closed'")
    List<Bug> findUnresolvedBugByUserId();

    @Query("SELECT COUNT(b) FROM Bug b WHERE b.project.id = :project_id")
    long countByProjectId(@Param("project_id") int project_id);

    // @Query("DELETE FROM Bug b WHERE b.id = :bugId")
    // void deleteById(@Param("bugId") Long bugId);
}
