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
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    // Many courses can belong to one professor
    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;

    // Many students can take many courses
    @ManyToMany(mappedBy = "courses")
    private List<Student> students = new ArrayList<>();

    public Course(String name, Professor professor) {
        this.name = name;
        this.professor = professor;
    }
}