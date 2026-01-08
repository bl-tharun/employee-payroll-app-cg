package com.bl.employeepayrollapp.session;

import com.bl.employeepayrollapp.model.uc5.Employee;

import java.util.ArrayList;

public interface Dashboard {
    void display(ArrayList payslips, Employee employee);
}
