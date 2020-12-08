package com.rage.bugtrackingserver.models;

import lombok.Data;

@Data
public class BugSubmit {
    private Long bugId;
    private String bugTitle;
    private String bugDescription;
    private boolean solved;
    private Long projectId;
}
