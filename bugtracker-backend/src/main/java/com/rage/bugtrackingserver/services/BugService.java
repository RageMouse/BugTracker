package com.rage.bugtrackingserver.services;

import com.rage.bugtrackingserver.entities.Bug;
import com.rage.bugtrackingserver.entities.Project;
import com.rage.bugtrackingserver.models.BugSubmit;
import com.rage.bugtrackingserver.repositories.BugRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class BugService {
    @Autowired
    private BugRepo bugRepo;

    public ResponseEntity<?> create(@RequestBody BugSubmit model, Project project) {
        Bug bug = new Bug(model.getBugTitle(), model.getBugDescription(), model.isSolved(), project);
        bugRepo.save(bug);
        return new ResponseEntity<>(bug, HttpStatus.CREATED);
    }

    public Iterable<Bug> getByProjectId(Long projectId) {
        return bugRepo.findBugsByProject_ProjectId(projectId);
    }
}
