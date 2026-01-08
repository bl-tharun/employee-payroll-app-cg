package com.bl.employeepayrollapp.session;

import com.bl.employeepayrollapp.model.uc5.Employee;
import com.bl.employeepayrollapp.model.uc5.Payslip;

import java.util.ArrayList;
import java.util.Iterator;

public class ManagerDashboard implements Dashboard {

    public void display(ArrayList payslips, Employee employee) {

        System.out.println("\n=== MANAGER DASHBOARD ===");
        System.out.println("Manager: " + employee.getName());

        System.out.println("Dashboard Type: " + this.getClass().getName());

        // YTD only
        double total = 0;
        Iterator it = payslips.iterator();
        while (it.hasNext()) {
            Payslip p = (Payslip) it.next();
            total += p.getNetPay();
        }

        System.out.println("\nTeam Total YTD Earnings: " + total);
    }
}
