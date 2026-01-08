package com.bl.employeepayrollapp.model;

import com.bl.employeepayrollapp.util.PasswordUtil;

public class RegularEmployee extends User {

    public RegularEmployee(String username, String password) {
        super(username, password, "EMPLOYEE");
    }

    public boolean authenticate(String username, String password) {
        return this.username.equals(username)
                && this.passwordHash.equals(PasswordUtil.hash(password));
    }
}
