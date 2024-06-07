package com.example.SpringTh.Repository;

import com.example.SpringTh.Entity.Project;
import com.example.SpringTh.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepo extends JpaRepository<Project, Long> {
    Project findByName(String projectName);
}
