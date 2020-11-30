package com.rage.bugtrackingserver.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
public class Bug {
    @Id
    @GeneratedValue
    private long bugId;

    @NotNull
    private String bugTitle;

    @NotNull
    private String bugDescription;

    @NotNull
    private boolean solved;

    @JsonBackReference
    @ManyToOne
    private Project project;

    public Bug() {
    }

    public Bug(String bugTitle, String bugDescription, boolean solved, Project project) {
        this.bugTitle = bugTitle;
        this.bugDescription = bugDescription;
        this.solved = solved;
        this.project = project;
    }
}
