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
@Table(name = "professors")
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // Many professors can belong to one department
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    // One professor can teach many courses
    @OneToMany(mappedBy = "professor")
    private List<Course> courses = new ArrayList<>();

    public Professor(String name, Department department) {
        this.name = name;
        this.department = department;
    }
}