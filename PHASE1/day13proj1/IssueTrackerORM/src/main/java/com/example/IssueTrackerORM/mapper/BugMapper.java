package com.example.IssueTrackerORM.mapper;
import com.example.IssueTrackerORM.domain.Bug;
import com.example.IssueTrackerORM.domain.Project;
import com.example.IssueTrackerORM.dto.BugRequestDTO;
import com.example.IssueTrackerORM.dto.BugResponseDTO;
public class BugMapper {
    public static Bug toEntity(BugRequestDTO dto,Project project){
        Bug bug=new Bug();
        bug.setTitle(dto.getTitle());
        bug.setDescription(dto.getDescription());
        bug.setStatus(dto.getStatus());
        bug.setPriority(dto.getPriority());
        bug.setProject(project);
        return bug;
    }

    public static BugResponseDTO toResponse(Bug bug){
        BugResponseDTO dto=new BugResponseDTO();
        dto.setId(bug.getId());
        dto.setTitle(bug.getTitle());
        dto.setDescription(bug.getDescription());
        dto.setStatus(bug.getStatus());
        dto.setPriority(bug.getPriority());
        dto.setProjectName(bug.getProject(bug) != null ? bug.getProjectName() : null);
        return dto;
    }
}
