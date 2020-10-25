package com.rage.bugtrackingserver.controllers;

import com.rage.bugtrackingserver.entities.Bug;
import com.rage.bugtrackingserver.entities.Project;
import com.rage.bugtrackingserver.models.BugSubmit;
import com.rage.bugtrackingserver.repositories.BugRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/bug")
public class BugController {
    BugRepo bugRepo;

    @GetMapping(path = "/" )
    public Iterable<Bug> bugs() {
        return bugRepo.findAll();
    }

    @PostMapping("/")
    public ResponseEntity<?> submitBug(@RequestBody BugSubmit bugSubmit) {
        Bug bug = new Bug();
        bugRepo.save(bug);
        return new ResponseEntity<>(bug, HttpStatus.CREATED);
    }
}
