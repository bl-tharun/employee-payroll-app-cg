package com.bl.employeepayrollapp;

import com.bl.employeepayrollapp.exception.ValidationException;
import com.bl.employeepayrollapp.service.ValidationService;

import java.util.Scanner;

public class UseCase6InputValidationApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== USE CASE 6: INPUT VALIDATION ===");

        try {
            System.out.print("Enter Employee ID (EMP-XXXX): ");
            String empId = sc.nextLine();
            ValidationService.validateEmployeeId(empId);

            System.out.print("Enter Email: ");
            String email = sc.nextLine();
            ValidationService.validateEmail(email);

            System.out.print("Enter Phone Number: ");
            String phone = sc.nextLine();
            ValidationService.validatePhone(phone);

            System.out.print("Create Password: ");
            String password = sc.nextLine();
            ValidationService.validatePassword(password);

            System.out.println("\n✅ All inputs are VALID. Registration/Login can proceed.");

        } catch (ValidationException ex) {
            System.out.println("\n⚠ Validation Failed:");
            System.out.println(ex.getMessage());
        }
    }
}
