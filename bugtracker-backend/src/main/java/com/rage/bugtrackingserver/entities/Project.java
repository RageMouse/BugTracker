package com.rage.bugtrackingserver.entities;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Project {
    @Id
    @GeneratedValue
    private Long projectId;

    @NotNull
    private String projectName;

    @NotNull
    private String projectDescription;

    @NotNull
    private boolean active;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "project")
    private List<Bug> projectBugList;

    public Project() {

    }

    public Project(String projectName, String projectDescription, boolean active) {
        this.projectName = projectName;
        this.projectDescription = projectDescription;
        this.active = active;
    }

    public Project(String projectName, String projectDescription, boolean active, List<Bug> projectBugList) {
        this.projectName = projectName;
        this.projectDescription = projectDescription;
        this.active = active;
        this.projectBugList = projectBugList;
    }
}
