package com.rage.bugtrackingserver.models;

import lombok.Data;

@Data
public class ProjectCreate {
    private String projectName;
    private String projectDescription;
    private boolean active;

    public ProjectCreate(String projectName, String projectDescription, boolean active) {
        this.projectName = projectName;
        this.projectDescription = projectDescription;
        this.active = active;
    }
}
