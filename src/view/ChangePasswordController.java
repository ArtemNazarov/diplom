package view;

import dialogs.DialogManager;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import sessionFactory.HibernateSessionFactory;

public class ChangePasswordController {
    public PasswordField newPasswordField;
    public PasswordField newPasswordAgainField;

    public void saveNewPassword(ActionEvent actionEvent) {
        if (!newPasswordField.getText().equals(newPasswordAgainField.getText())){
            DialogManager.showErrorDialog("Введённые пароли не совпадают!");
        } else {
            Session session = HibernateSessionFactory.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            Query query = session.createQuery("update UsersEntity set userPassword = :passwordParam where id = :login");
            query.setParameter("passwordParam",newPasswordAgainField.getText());
            query.setParameter("login",Profile.getCurrent_login());
            query.executeUpdate();
            DialogManager.showInformationDialog("Вы успешно изменили пароль");
            tx.commit();
            session.close();
            Stage stageTheEventSourceNodeBelongs = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stageTheEventSourceNodeBelongs.close();
        }
    }

    public void closePasswordCh(ActionEvent actionEvent) {
        Stage stageTheEventSourceNodeBelongs = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stageTheEventSourceNodeBelongs.close();
    }
}
