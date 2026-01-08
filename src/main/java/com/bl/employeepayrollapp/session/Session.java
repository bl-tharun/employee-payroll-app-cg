package com.bl.employeepayrollapp.session;

public class Session {

    private String username;
    private long loginTime;      // milliseconds
    private long timeoutMillis;  // 2 minutes

    public Session(String username) {
        this.username = username;
        this.loginTime = System.currentTimeMillis();
        this.timeoutMillis = 2 * 60 * 1000;   // 2 minutes
    }

    public boolean isExpired() {
        long current = System.currentTimeMillis();
        return (current - loginTime) > timeoutMillis;
    }

    public String toString() {
        return "Session active for user: " + username;
    }
}
