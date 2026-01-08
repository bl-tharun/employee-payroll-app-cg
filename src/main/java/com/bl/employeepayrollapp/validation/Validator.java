package com.bl.employeepayrollapp.validation;

import com.bl.employeepayrollapp.exception.ValidationException;

import java.util.regex.Pattern;

public class Validator {

    // validation for name e.g. Abi/Abhi -> should be at least 3 letters and starts with a capital letter
    public static void validateName(String name) throws ValidationException {
        String regex = "^[A-Z]{1}[a-zA-Z\\s]{2,}$";
        if (!Pattern.matches(regex, name)) {
            throw new ValidationException("Invalid Name Format!");
        }
    }

    // validation for email e.g. abi@bridgelabz.com
    public static void validateEmail(String email) throws ValidationException {
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        if (!Pattern.matches(regex, email)) {
            throw new ValidationException("Invalid Email Format!");
        }
    }

    // validation for phone number e.g. 9876543211 -> should be 10 digits and follow Indian phone number format
    public static void validatePhone(String phone) throws ValidationException {
        String regex = "^[6-9]\\d{9}$";
        if (!Pattern.matches(regex, phone)) {
            throw new ValidationException("Invalid Indian Phone Number!");
        }
    }

    // validation for Employee Id e.g. EMP-0001 to EMP-9999
    public static void validateEmpId(String empId) throws ValidationException {
        String regex = "EMP-\\d{4}";
        if (!Pattern.matches(regex, empId)) {
            throw new ValidationException("Invalid Employee ID! Expected format: EMP-XXXX");
        }
    }
}
