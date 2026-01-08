package com.bl.employeepayrollapp;

import com.bl.employeepayrollapp.model.uc5.Employee;
import com.bl.employeepayrollapp.model.uc5.Payslip;
import com.bl.employeepayrollapp.session.Dashboard;
import com.bl.employeepayrollapp.session.DashboardFactory;

import java.util.ArrayList;
import java.util.Scanner;

public class UseCase5DashboardApp {

    public static void main(String[] args) {

        System.out.println("=== USE CASE 5: DASHBOARD DISPLAY ===");

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Employee ID: ");
        String id = sc.nextLine();

        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Role (EMPLOYEE/MANAGER): ");
        String role = sc.nextLine();

        Employee emp = new Employee(id, name);

        // sample payslip data
        ArrayList payslips = new ArrayList();
        payslips.add(new Payslip("Jan", 30000));
        payslips.add(new Payslip("Feb", 32000));
        payslips.add(new Payslip("Mar", 31000));
        payslips.add(new Payslip("Apr", 33000));
        payslips.add(new Payslip("May", 34000));

        // Abstract factory usage
        Dashboard dashboard = DashboardFactory.getDashboard(role);

        if (dashboard != null) {
            dashboard.display(payslips, emp);
        } else {
            System.out.println("Invalid Role");
        }
    }
}
