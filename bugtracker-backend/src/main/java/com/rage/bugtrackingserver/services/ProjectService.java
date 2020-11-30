package com.rage.bugtrackingserver.services;

import com.rage.bugtrackingserver.entities.Project;
import com.rage.bugtrackingserver.models.ProjectCreate;
import com.rage.bugtrackingserver.repositories.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepo projectRepo;

    public ResponseEntity<?> createProject(@RequestBody ProjectCreate model) {
        Project project = new Project(model.getProjectName(), model.getProjectDescription(), model.isActive());
        projectRepo.save(project);
        return new ResponseEntity<>(project, HttpStatus.CREATED);
    }

    public Project findByProjectId(Long projectId){
        return projectRepo.getByProjectId(projectId);
    }
}
