package com.example.StudentCourseManagement.domain;

import jakarta.annotation.Generated;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.*;


@Entity@Table(name = "students")
public class Student {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @NotBlank(message="name not be null")
    private String name;
    @NotBlank
    @Email(message="the email format is invalid")
    private String email;

    // @OneToMany(mappedBy="student_id")
    // private List<Enrollment> enrollments;

    // @OneToMany(mappedBy="course_id")
    // private List<Course> courses;

    // @ManyToOne(cascade = CascadeType.ALL)
    // @JoinColumn(name = "course_id", referencedColumnName = "id")
    // private Course course;

     @OneToMany(mappedBy = "student")
    private List<Enrollment> enrollments;

    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    
}
