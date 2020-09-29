package com.rage.bugtrackingserver.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HelloMessage {
    private String name;
    private String message;

    public HelloMessage() {
    }

    public HelloMessage(String name, String message) {
        this.name = name;
        this.message = message;
    }
}
