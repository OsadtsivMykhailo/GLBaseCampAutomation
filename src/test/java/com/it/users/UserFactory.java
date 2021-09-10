package com.it.users;

import java.util.ResourceBundle;
import java.util.Scanner;

public class UserFactory {
    static ResourceBundle user = ResourceBundle.getBundle("user");
    public static User getValidUser() {
        return new User(user.getString("login"), user.getString("password"), user.getString("email"));
    }
}
