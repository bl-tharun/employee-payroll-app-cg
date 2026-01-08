package com.bl.employeepayrollapp.service;

import com.bl.employeepayrollapp.model.Employee;
import com.bl.employeepayrollapp.model.Payslip;

class PayrollService {

    public Payslip generatePayslip(Employee employee,
                                   String month,
                                   double basic,
                                   double hra,
                                   double da,
                                   double allowances) {

        // ---- Gross Salary ----
        double gross = basic + hra + da + allowances;

        // ---- Deductions ----
        double pf = basic * 0.12;      // 12% PF
        double tax = gross * 0.10;     // 10% tax

        // ---- Net Pay ----
        double netPay = gross - (pf + tax);

        // ---- Create IMMUTABLE Payslip ----
        return new Payslip(
                employee.getEmpId(),
                employee.getName(),
                month,
                netPay
        );
    }
}

