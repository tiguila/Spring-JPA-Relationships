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
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    // One department can have many students
    @OneToMany(mappedBy = "department")
    private List<Student> students = new ArrayList<>();

    // One department can have many professors
    @OneToMany(mappedBy = "department")
    private List<Professor> professors = new ArrayList<>();

    public Department(int id, String name,
                      List<Student> students,
                      List<Professor> professors) {
        this.id = id;
        this.name = name;
        this.students = students;
        this.professors = professors;
    }
}