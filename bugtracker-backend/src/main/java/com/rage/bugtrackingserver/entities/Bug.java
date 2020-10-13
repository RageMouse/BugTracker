package com.rage.bugtrackingserver.entities;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
}
