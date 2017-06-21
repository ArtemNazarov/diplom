package db;

import javafx.beans.property.SimpleStringProperty;

import javax.persistence.*;

@Entity
@Table(name = "users", schema = "public", catalog = "toy_factory")
public class UsersEntity {
    private SimpleStringProperty userLogin = new SimpleStringProperty();
    private SimpleStringProperty userPassword = new SimpleStringProperty();
    private UserRole userRole;


    @Id
    @Column(name = "user_login", nullable = false, length = 150)
    public String getUserLogin() {
        return userLogin.get();
    }

    public void setUserLogin(String userLogin) {
        this.userLogin.set(userLogin);
    }

    @Basic
    @Column(name = "user_password", nullable = false, length = 150)
    public String getUserPassword() {
        return userPassword.get();
    }

    public void setUserPassword(String userPassword) {
        this.userPassword.set(userPassword);
    }

    @Convert(converter = UsersEntity.RoleConverter.class)
    @Column(name = "user_role", nullable = false, updatable = false)
    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersEntity that = (UsersEntity) o;

        if (userLogin != null ? !userLogin.equals(that.userLogin) : that.userLogin != null) return false;
        if (userPassword != null ? !userPassword.equals(that.userPassword) : that.userPassword != null) return false;
        if (userRole != null ? !userRole.equals(that.userRole) : that.userRole != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userLogin != null ? userLogin.hashCode() : 0;
        result = 31 * result + (userPassword != null ? userPassword.hashCode() : 0);
        result = 31 * result + (userRole != null ? userRole.hashCode() : 0);
        return result;
    }

    @Converter
    public static class RoleConverter implements AttributeConverter<UserRole, String> {

        @Override
        public String convertToDatabaseColumn(UserRole userRole) {
            if (userRole == null)
                return null;
            return userRole.getRole();
        }

        @Override
        public UserRole convertToEntityAttribute(String s) {
            if (s == null)
                return null;
            return UserRole.fromRoleName(s);
        }
    }

    public SimpleStringProperty userLoginProperty() {
        return userLogin;
    }

    public SimpleStringProperty userPasswordProperty() {
        return userPassword;
    }
}
