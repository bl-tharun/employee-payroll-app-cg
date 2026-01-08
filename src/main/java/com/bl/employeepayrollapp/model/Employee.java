package com.bl.employeepayrollapp.model;

import java.io.FileWriter;
import java.io.IOException;

public class Employee {

    private String empId;
    private String name;
    private String email;
    private String phone;
    private UserAccount account; // HAS–A relationship

    public Employee(String empId, String name, String email, String phone, UserAccount account) {
        this.empId = empId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.account = account;
    }

    @Override
    public String toString() {
        return "Employee Registered Successfully:\n" +
                "Employee ID : " + empId + "\n" +
                "Name        : " + name + "\n" +
                "Email       : " + email + "\n" +
                "Phone       : " + phone + "\n" +
                "Username    : " + account.getUsername();
    }

    // Persist employee to a text file
    public void persist() throws IOException {
        FileWriter writer = new FileWriter("employee_data.txt", true);
        writer.write(empId + "," + name + "," + email + "," + phone + "," + account.getUsername() + "\n");
        writer.close();
    }
}
