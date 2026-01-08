package com.bl.employeepayrollapp.service;

import com.bl.employeepayrollapp.exception.EmailValidationException;
import com.bl.employeepayrollapp.exception.EmployeeIdValidationException;
import com.bl.employeepayrollapp.exception.PasswordValidationException;
import com.bl.employeepayrollapp.exception.PhoneValidationException;

import java.util.regex.Pattern;

public class ValidationService {

    // sanitization (remove extra spaces)
    private static String sanitize(String input) {
        if (input == null) return "";
        return input.trim().replace(" ", "");
    }

    public static void validateEmail(String email) throws EmailValidationException {

        email = sanitize(email);

        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

        if (!Pattern.matches(regex, email)) {
            throw new EmailValidationException("❌ Invalid email format. Example: abc@gmail.com");
        }
    }

    public static void validatePhone(String phone) throws PhoneValidationException {

        phone = sanitize(phone);

        String regex = "^[6-9][0-9]{9}$";

        if (!Pattern.matches(regex, phone)) {
            throw new PhoneValidationException("❌ Invalid phone number. Must be 10 digits starting from 6–9");
        }
    }

    public static void validatePassword(String password) throws PasswordValidationException {

        password = sanitize(password);

        // at least 8 chars, 1 upper, 1 lower, 1 digit, 1 special char
        String regex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[@#$%!]).{8,}$";

        if (!Pattern.matches(regex, password)) {
            throw new PasswordValidationException(
                    "❌ Weak password. Must contain:\n" +
                            "- 8 or more characters\n" +
                            "- uppercase letter\n" +
                            "- lowercase letter\n" +
                            "- number\n" +
                            "- special symbol (@ # $ % !)"
            );
        }
    }

    public static void validateEmployeeId(String empId) throws EmployeeIdValidationException {

        empId = sanitize(empId);

        String regex = "^EMP-[0-9]{4}$";

        if (!Pattern.matches(regex, empId)) {
            throw new EmployeeIdValidationException("❌ Invalid Employee ID. Expected format: EMP-1234");
        }
    }
}
