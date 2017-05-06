package view;

import db.UserRole;

public class Profile {

    private static String current_login;
    private static String current_password;
    private static UserRole current_userRole;

    public static void setCurrent_login(String current_login) {
        Profile.current_login = current_login;
    }

    public static void setCurrent_password(String current_password) {
        Profile.current_password = current_password;
    }

    public static void setCurrent_userRole(UserRole current_userRole) {
        Profile.current_userRole = current_userRole;
    }

    public static String getCurrent_login() {

        return current_login;
    }

    public static String getCurrent_password() {
        return current_password;
    }

    public static UserRole getCurrent_userRole() {
        return current_userRole;
    }
}
