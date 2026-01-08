package com.bl.employeepayrollapp.model;

public class UserAccount {
    private String username;
    private String password;   // Note: plain text for demo only

    public UserAccount(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() { return username; }

    @Override
    public String toString() {
        return "UserAccount{username='" + username + "'}";
    }
}
