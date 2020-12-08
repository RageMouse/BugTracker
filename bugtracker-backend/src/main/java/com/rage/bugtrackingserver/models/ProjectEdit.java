package com.rage.bugtrackingserver.models;

import lombok.Data;

@Data
public class ProjectEdit {
    private Long projectId;
    private String projectName;
    private String projectDescription;
    private boolean active;

    public ProjectEdit(Long projectId,String projectName, String projectDescription, boolean active) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.projectDescription = projectDescription;
        this.active = active;
    }
}
