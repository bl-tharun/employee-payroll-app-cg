package com.bl.employeepayrollapp.model;

public class SalaryComponents {

    double basicSalary;
    double hra;
    double da;
    double allowances;
    public double pf;
    public double tax;
    public double netPay;

    public SalaryComponents(double basicSalary, double hra, double da, double allowances) {
        this.basicSalary = basicSalary;
        this.hra = hra;
        this.da = da;
        this.allowances = allowances;
    }
}
