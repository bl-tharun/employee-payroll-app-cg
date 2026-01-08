package com.bl.employeepayrollapp;

import com.bl.employeepayrollapp.exception.ValidationException;
import com.bl.employeepayrollapp.model.Employee;
import com.bl.employeepayrollapp.model.UserAccount;
import com.bl.employeepayrollapp.validation.Validator;

import java.io.IOException;
import java.util.Scanner;

public class EmployeeRegistrationApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== USE CASE 1: EMPLOYEE REGISTRATION ===");

        try {
            System.out.print("Enter Employee ID (EMP-XXXX): ");
            String empId = sc.nextLine();
            Validator.validateEmpId(empId);

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Email: ");
            String email = sc.nextLine();
            Validator.validateEmail(email);

            System.out.print("Enter Phone (10 digits starting 6-9): ");
            String phone = sc.nextLine();
            Validator.validatePhone(phone);

            System.out.print("Create Username: ");
            String username = sc.nextLine();

            System.out.print("Create Password: ");
            String password = sc.nextLine();

            // Create account and employee objects
            UserAccount account = new UserAccount(username, password);
            Employee employee = new Employee(empId, name, email, phone, account);

            // Persist employee data
            employee.persist();

            // Confirm Registration
            System.out.println("\n----------------------------------");
            System.out.println(employee);
            System.out.println("\nData persisted in file: employee_data.txt");
            System.out.println("----------------------------------");

        } catch (ValidationException e) {
            System.out.println("\nValidation Failed: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("\nError saving employee data!");
        }
    }
}
