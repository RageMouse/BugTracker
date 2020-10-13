package com.rage.bugtrackingserver.entities;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue
    private Long userId;

    @NotNull
    private String userName;

    @NotNull
    private String userPassword;
}
