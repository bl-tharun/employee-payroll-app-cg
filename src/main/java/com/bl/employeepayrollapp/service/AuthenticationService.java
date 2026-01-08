package com.bl.employeepayrollapp.service;

import com.bl.employeepayrollapp.model.Manager;
import com.bl.employeepayrollapp.model.RegularEmployee;
import com.bl.employeepayrollapp.model.User;
import com.bl.employeepayrollapp.session.Session;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AuthenticationService {

    private Map<String, User> users = new HashMap<>();
    private int maxAttempts = 3;

    public AuthenticationService() {
        // predefined demo users
        users.put("emp1", new RegularEmployee("emp1", "Emp@1234"));
        users.put("manager1", new Manager("manager1", "Mng@1234"));
    }

    public Session login() {

        Scanner sc = new Scanner(System.in);
        int attempts = 0;

        while (attempts < maxAttempts) {

            System.out.print("\nEnter Username: ");
            String username = sc.nextLine();

            System.out.print("Enter Password: ");
            String password = sc.nextLine();

            User user = (User) users.get(username);

            if (user != null && user.authenticate(username, password)) {

                System.out.println("\nLogin Successful!");
                System.out.println("Role: " + user.getRole());

                Session session = new Session(username);

                showDashboard(user.getRole());

                return session;
            }

            attempts++;
            System.out.println("Login Failed. Attempts remaining: " + (maxAttempts - attempts));
        }

        System.out.println("\nAccount temporarily locked due to 3 failed attempts.");
        return null;
    }

    private void showDashboard(String role) {

        System.out.println("\n======= DASHBOARD =======");

        if ("EMPLOYEE".equals(role)) {
            System.out.println("Employee Dashboard");
            System.out.println("View Payslip | Update Profile");

        } else if ("MANAGER".equals(role)) {
            System.out.println("Manager Dashboard");
            System.out.println("Approve Payslip | View Team Summary");
        }
    }
}
