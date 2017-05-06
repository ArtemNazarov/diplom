package view;

import db.UsersEntity;
import dialogs.DialogManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import sessionFactory.HibernateSessionFactory;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class EnterController implements Initializable {
    public TextField loginField;
    public Button enterButton;
    public Hyperlink forgottenPasswordHyperlink;
    public Hyperlink registrationHyperLink;
    public PasswordField passwordField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    public void enterAction(ActionEvent actionEvent) {
        List<UsersEntity> usersList = selectUser();
        if (usersList == null) {
            DialogManager.showErrorDialog("Ошибка соединения с базой данных!");
            actionEvent.consume();
        }
        if (usersList != null) {
            if (usersList.isEmpty()) {
                DialogManager.showErrorDialog("Пользователь с данным логином не зарегистрирован в системе!");
            } else {
                usersList.clear();
                usersList = selectUserLoginPassword();
                if (usersList.isEmpty()) {
                    DialogManager.showErrorDialog("Неверный пароль!");
                } else {
                    Stage stageTheEventSourceNodeBelongs = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                    try {
                        UsersEntity user = usersList.get(0);
                        Profile.setCurrent_login(user.getUserLogin());
                        Profile.setCurrent_password(user.getUserPassword());
                        Profile.setCurrent_userRole(user.getUserRole());
                        String resource = "";
                        switch (user.getUserRole()) {
                            case ADMIN:
                                resource = "admin.fxml";
                                break;
                            case CUSTOMER:
                                resource = "user.fxml";
                                break;
                            case EMPLOYEE:
                                resource = "employee.fxml";
                                break;
                        }
                        Parent main = FXMLLoader.load(getClass().getResource(resource));
                        Notifications.create().title("Информация").text("Вы успешно вошли в систему!").position(Pos.BOTTOM_RIGHT).showConfirm();
                        stageTheEventSourceNodeBelongs.setScene(new Scene(main));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }

    public List<UsersEntity> selectUserLoginPassword() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("FROM UsersEntity WHERE userLogin = :log_param AND userPassword = :pass_param");
        query.setParameter("log_param", loginField.getText());
        query.setParameter("pass_param", passwordField.getText());
        List<UsersEntity> usersList = query.list();
        tx.commit();
        session.close();
        return usersList;
    }

    public void forgottenPasswordAction(ActionEvent actionEvent) {
        List<UsersEntity> usersList = selectUser();
        if (usersList.isEmpty()) {
            DialogManager.showErrorDialog("Пользователь с данным логином не зарегистрирован в системе!");
        } else {
            DialogManager.showInformationDialog("Пароль был выслан на e-mail, который был указан при " +
                    "регистрации вашего аккаунта");
        }
    }

    public List<UsersEntity> selectUser() {
        List<UsersEntity> usersList = null;
        try {
            Session session = HibernateSessionFactory.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            Query query = session.createQuery("FROM UsersEntity WHERE userLogin = :log_param");
            query.setParameter("log_param", loginField.getText());
            usersList = query.list();
            tx.commit();
            session.close();
        } catch (ExceptionInInitializerError e) {
            e.printStackTrace();
        }

        return usersList;
    }

    public void registrationAction(ActionEvent actionEvent) {
        Stage stageTheEventSourceNodeBelongs = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        try {
            Parent reg = FXMLLoader.load(getClass().getResource("register.fxml"));
            stageTheEventSourceNodeBelongs.setScene(new Scene(reg));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
