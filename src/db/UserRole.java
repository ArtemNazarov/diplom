package db;

public enum UserRole {
    ADMIN("Администратор"),CUSTOMER("Покупатель"),EMPLOYEE("Сотрудник");

    private String role;

    UserRole(String u_role) {
        role = u_role;
    }

    public String getRole() {
        return role;
    }

    public static UserRole fromRoleName(String role){
        switch (role) {
            case "Администратор":
                return ADMIN;
            case "Покупатель":
                return CUSTOMER;
            case "Сотрудник":
                return EMPLOYEE;
        }

        throw new UnsupportedOperationException(
                "The role " + role + " is not supported!"
        );
    }


}
