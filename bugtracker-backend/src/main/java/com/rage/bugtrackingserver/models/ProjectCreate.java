package com.rage.bugtrackingserver.models;

import lombok.Data;

@Data
public class ProjectCreate {
    private Long projectId;
    private String projectName;
    private String projectDescription;
    private boolean active;
}
