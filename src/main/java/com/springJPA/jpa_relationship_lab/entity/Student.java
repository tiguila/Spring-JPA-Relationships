package com.springJPA.jpa_relationship_lab.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

//    a dept can have many students-- > many-to-one
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

//    a course can have many students and a students can take many courses -- many-to-many
    @ManyToMany
    @JoinTable(
            name = "student_courses",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Course> courses = new ArrayList<>();

    public Student(int id, String name, Department department, List<Course> courses) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.courses = courses;
    }
}