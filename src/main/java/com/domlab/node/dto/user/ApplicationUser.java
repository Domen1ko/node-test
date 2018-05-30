package com.domlab.node.dto.user;

import javax.validation.constraints.NotNull;

public class ApplicationUser {

    @NotNull
    private String userId;
    private String password;

    public ApplicationUser(@NotNull String userId) {
        this.userId = userId;
    }


    public ApplicationUser() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "ApplicationUser{" + "userId='" + userId + '\'' +
                ", password='********'" +
                '}';
    }
}
