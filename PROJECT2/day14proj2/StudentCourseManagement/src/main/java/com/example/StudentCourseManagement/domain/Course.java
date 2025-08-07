package com.example.StudentCourseManagement.domain;
import java.util.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "courses")
public class Course {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message="title not be blank")
    @Size(min=3,max=20,message="should be between 3 to 20 letters")
    private String title;
    @NotBlank(message="description should not be blank")
    private String description;

    @OneToMany(mappedBy = "course")
    private List<Enrollment> enrollments;

    public Course(){

    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    
}
