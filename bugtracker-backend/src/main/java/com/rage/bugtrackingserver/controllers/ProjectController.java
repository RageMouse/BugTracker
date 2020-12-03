package com.rage.bugtrackingserver.controllers;

import com.rage.bugtrackingserver.entities.Project;
import com.rage.bugtrackingserver.models.ProjectCreate;
import com.rage.bugtrackingserver.models.ProjectEdit;
import com.rage.bugtrackingserver.repositories.ProjectRepo;
import com.rage.bugtrackingserver.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/project")
public class ProjectController {
    @Autowired
    private ProjectRepo projectRepo;

    @Autowired
    private ProjectService projectService;

    @GetMapping(path = "/" )
    public Iterable<Project> projects() {
        return projectRepo.findAll();
    }

    @PostMapping("/")
    public ResponseEntity<?> createProject(@RequestBody ProjectCreate model) {
        return projectService.createProject(model);
    }

    @GetMapping(path = "/{id}" )
    public Optional<Project> findById(@PathVariable("id") Long id) {
        return projectRepo.findById(id);
    }

    @PutMapping(path = "/")
    public ResponseEntity<?> editProject(@RequestBody ProjectEdit projectEdit){
        Project project = projectRepo.getByProjectId(projectEdit.getProjectId());
        project.setProjectName(projectEdit.getProjectName());
        project.setProjectDescription(projectEdit.getProjectDescription());

        projectRepo.save(project);
        return new ResponseEntity<>(project, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteProject(@PathVariable("id") Long id) {
        projectService.delete(id);
    }
}
