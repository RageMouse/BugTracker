package com.rage.bugtrackingserver.models;

import lombok.Getter;

public class Greeting {
    @Getter
    private String content;

    public Greeting() {
    }

    public Greeting(String content) {
        this.content = content;
    }
}
