package com.bl.employeepayrollapp.session;

public class DownloadToken {

    private long createdTime;
    private long expiryMillis; // validity period

    public DownloadToken() {
        createdTime = System.currentTimeMillis();
        expiryMillis = 60 * 1000; // 1 minute for demo
    }

    public boolean isExpired() {
        long now = System.currentTimeMillis();
        return (now - createdTime) > expiryMillis;
    }
}