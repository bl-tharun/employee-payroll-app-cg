package com.bl.employeepayrollapp.model.uc5;

public class Employee {
    private String empId;
    private String name;

    public Employee(String empId, String name) {
        this.empId = empId;
        this.name = name;
    }

    public String getEmpId() { return empId; }
    public String getName() { return name; }
}
