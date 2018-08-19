package com.greenfox.springvalidation.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserCredentials {

    @NotNull
    @Size(min = 4)
    private String username;

    @NotNull
    @Size(min = 4)
    private String password;

    public UserCredentials() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
