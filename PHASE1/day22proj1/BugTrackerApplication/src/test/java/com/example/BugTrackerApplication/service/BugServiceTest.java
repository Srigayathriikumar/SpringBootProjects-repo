package com.example.BugTrackerApplication.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.example.BugTrackerApplication.repository.BugRepository;
import com.example.BugTrackerApplication.dto.BugResponseDTO;
import com.example.BugTrackerApplication.entity.Bug;
import java.util.List;

public class BugServiceTest {
    @Mock
    private BugRepository bugRepository;

    @InjectMocks
    private BugService bugService;

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateBug(){
        Bug bug = new Bug();
        bug.setTitle("Login issue");
        when(bugRepository.save(bug)).thenReturn(bug);
        Bug createdBug = bugService.createBug(bug);
        assertNotNull(createdBug);
        assertEquals("Login issue",createdBug.getTitle());
        verify(bugRepository, times(1)).save(bug);
    }

    @Test
    void testGetallBugs(){
        Bug bug1=new Bug();bug1.setTitle("Issue 1");
        Bug bug2=new Bug();bug2.setTitle("Issue 2");
        when(bugRepository.findAll()).thenReturn(List.of(bug1,bug2));
        List<BugResponseDTO> bugs = bugService.getAllBugs();
        assertEquals(2, bugs.size());
        assertEquals("Issue 1", bugs.get(0).getTitle());
        verify(bugRepository, times(1)).findAll();
    }

    @Test
    void testDeleteBug(){
        bugService.deleteBug(1L);
        verify(bugRepository, times(1)).deleteById(1L);
    }

    @Test
    void testUpdateBug(){
        Bug bug = new Bug();
        bug.setId(1L);
        bug.setTitle("Updated Issue");
        when(bugRepository.save(bug)).thenReturn(bug);
        Bug updatedBug = bugService.updateBug(1L, bug);
        assertNotNull(updatedBug);
        assertEquals("Updated Issue", updatedBug.getTitle());
        verify(bugRepository, times(1)).save(bug);
    }
}