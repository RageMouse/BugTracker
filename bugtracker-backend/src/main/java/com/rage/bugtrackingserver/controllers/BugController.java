package com.rage.bugtrackingserver.controllers;

import com.rage.bugtrackingserver.entities.Bug;
import com.rage.bugtrackingserver.entities.Project;
import com.rage.bugtrackingserver.models.BugSubmit;
import com.rage.bugtrackingserver.repositories.BugRepo;
import com.rage.bugtrackingserver.services.BugService;
import com.rage.bugtrackingserver.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/bug")
public class BugController {
    @Autowired
    private BugService bugService;

    @Autowired
    private ProjectService projectService;

    @GetMapping("/{projectId}")
    public Iterable<Bug> bugs(@PathVariable Long projectId) {
        return bugService.getByProjectId(projectId);
    }

    @PostMapping("/")
    public ResponseEntity<?> submitBug(@RequestBody BugSubmit bugSubmit) {
        Project project = projectService.findByProjectId(bugSubmit.getProjectId());
        return bugService.create(bugSubmit, project);
    }
}
