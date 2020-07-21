package com.rage.bugtrackingserver.models;

import lombok.Getter;
import lombok.Setter;

public class HelloMessage {
    @Getter
    @Setter
    private String name;

    public HelloMessage() {
    }

    public HelloMessage(String name) {
        this.name = name;
    }
}
