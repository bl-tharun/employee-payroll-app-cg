package com.bl.employeepayrollapp.session;

import com.bl.employeepayrollapp.model.uc5.Payslip;
import com.bl.employeepayrollapp.model.uc5.Employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class EmployeeDashboard implements Dashboard {

    public void display(ArrayList payslips, Employee employee) {

        System.out.println("\n=== EMPLOYEE DASHBOARD ===");
        System.out.println("Welcome, " + employee.getName());

        // runtime type checking
        System.out.println("Dashboard Type: " + this.getClass().getName());

        // sort descending by net pay
        Collections.sort(payslips, new Comparator() {
            public int compare(Object o1, Object o2) {
                Payslip p1 = (Payslip) o1;
                Payslip p2 = (Payslip) o2;
                return (int)(p2.getNetPay() - p1.getNetPay());
            }
        });

        // recent top 3 payslips
        System.out.println("\nRecent Payslips (Top 3):");
        int count = 0;
        Iterator it = payslips.iterator();
        while (it.hasNext() && count < 3) {
            Payslip p = (Payslip) it.next();
            System.out.println(p);
            count++;
        }

        // YTD earnings
        double total = 0;
        Iterator it2 = payslips.iterator();
        while (it2.hasNext()) {
            Payslip p = (Payslip) it2.next();
            total += p.getNetPay();
        }

        System.out.println("\nYear-To-Date Earnings: " + total);
    }
}

