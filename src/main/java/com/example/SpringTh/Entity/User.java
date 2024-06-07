package com.example.SpringTh.Entity;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Table(name="user")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", length = 10)
    private Long id_user;

    @Column(name = "first_name", length = 255)
     private String firstname ;


    @Column(name = "email", length = 255)
    private String email;


    @Column(name = "skill", length = 255)
    private String skill;

    @ManyToMany
    @JoinTable(
            name = "mtom",
            joinColumns = @JoinColumn(name = "eid"),
            inverseJoinColumns = @JoinColumn(name = "pid"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"id", "pid"})
    )
    private Set<Project> projects = new HashSet<>();

    public Set<Project> getProjets() {
        return projects;
    }

    public void setProjets(Set<Project> projets) {
        this.projects = projets;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }


    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public User() {
    }

    public User(String email, String firstname, Long id_user, Set<Project> project, String skill) {
        this.email = email;
        this.firstname = firstname;
        this.id_user = id_user;
        this.projects = project;
        this.skill = skill;
    }
}
