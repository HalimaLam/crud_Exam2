package com.example.SpringTh.Service;

import com.example.SpringTh.Entity.Project;
import com.example.SpringTh.Entity.User;

import java.util.List;

public interface ProjectService {
    List<Project> getAllProject();
    void saveProject(Project project);


}
