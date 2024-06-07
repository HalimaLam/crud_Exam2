package com.example.SpringTh.Service;

import com.example.SpringTh.Entity.Project;
import com.example.SpringTh.Repository.ProjectRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService{

    private final ProjectRepo projectRepo;

    public ProjectServiceImpl(ProjectRepo projectRepo) {
        this.projectRepo = projectRepo;
    }


    @Override
    public List<Project> getAllProject() {
        return projectRepo.findAll();
    }

    @Override
    public void saveProject(Project project) {
        projectRepo.save(project);
    }
}
