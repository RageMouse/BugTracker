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

    @OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "project_bug",
            joinColumns = {@JoinColumn(name = "projectId")},
            inverseJoinColumns = {@JoinColumn(name = "bugId")})
    private List<Bug> projectBugList;
}
