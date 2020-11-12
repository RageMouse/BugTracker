package com.rage.bugtrackingserver.models;

import lombok.Data;

@Data
public class BugSubmit {
    private long bugId;
    private String bugTitle;
    private String bugDescription;
    private boolean solved;
}
