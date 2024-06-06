package com.example.SpringTh.Entity;

import jakarta.persistence.*;

import java.util.Date;

@Table(name="user")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", length = 10)
    private Long id_user;

    @Column(name = "first_name", length = 255)
     private String firstname ;

    @Column(name = "last_name", length = 255)
    private String lastname;

    @Column(name = "email", length = 255)
    private String email;



    public String getEmail() {
        return email;
    }
    public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }

    public User() {
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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public User(String email, String firstname, Long id_user, String lastname) {
        this.email = email;
        this.firstname = firstname;
        this.id_user = id_user;
        this.lastname = lastname;
    }
}
