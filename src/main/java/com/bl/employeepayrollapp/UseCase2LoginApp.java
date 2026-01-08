package com.bl.employeepayrollapp;

import com.bl.employeepayrollapp.service.AuthenticationService;
import com.bl.employeepayrollapp.session.Session;

public class UseCase2LoginApp {

    public static void main(String[] args) {

        System.out.println("=== USE CASE 2: EMPLOYEE AUTHENTICATION & LOGIN ===");

        AuthenticationService auth = new AuthenticationService();
        Session session = auth.login();

        if (session != null) {

            System.out.println("\n" + session.toString());

            if (session.isExpired()) {
                System.out.println("Session expired. Please login again.");
            } else {
                System.out.println("Session active and valid.");
            }
        }
    }
}
