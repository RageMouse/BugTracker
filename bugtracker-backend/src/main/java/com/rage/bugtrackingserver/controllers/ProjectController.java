package com.rage.bugtrackingserver.controllers;

import com.rage.bugtrackingserver.entities.Project;
import com.rage.bugtrackingserver.models.ProjectCreate;
import com.rage.bugtrackingserver.repositories.ProjectRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/project")
public class ProjectController {
    ProjectRepo projectRepo;

    @GetMapping(path = "/" )
    public Iterable<Project> projects() {
        return projectRepo.findAll();
    }

    @PostMapping("/")
    public ResponseEntity<?> createProject(@RequestBody ProjectCreate model) {
        Project project = new Project();
        projectRepo.save(project);
        return new ResponseEntity<>(project, HttpStatus.CREATED);
    }
}
