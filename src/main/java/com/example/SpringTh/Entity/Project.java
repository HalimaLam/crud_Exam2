package com.example.SpringTh.Entity;


import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Table(name="project")
@Entity
public class Project {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id_project;

    @Column(name="name",length = 255)
    private  String name;
    @Column(name="budget",length = 20)
    private float budget;

    @ManyToMany
    @JoinTable(
            name = "mtom",
            joinColumns = @JoinColumn(name = "pid"),
            inverseJoinColumns = @JoinColumn(name = "eid"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"pid", "eid"})
    )
    private Set<User> users = new HashSet<>();


    public float getBudget() {
        return budget;
    }

    public void setBudget(float budget) {
        this.budget = budget;
    }

    public Long getId_project() {
        return id_project;
    }

    public void setId_project(Long id_project) {
        this.id_project = id_project;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Project() {
    }

    public Project(float budget, Long id_project, String name) {
        this.budget = budget;
        this.id_project = id_project;
        this.name = name;
    }


}
