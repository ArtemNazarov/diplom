package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import sessionFactory.HibernateSessionFactory;

import java.io.IOException;

public class RegisterController {

    public Button cancelButton;
    public Button registerButton;
    public TextField surnameField;
    public TextField nameField;
    public TextField patroField;
    public TextField ogrnField;
    public TextField innField;
    public TextField cityField;
    public TextField phoneField;
    public TextField loginField;
    public TextField passwordField;
    public TextField firmTitleField;
    public TextField emailField;

    public void registerAction(ActionEvent actionEvent) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createNativeQuery("INSERT INTO users VALUES (\'" + loginField.getText() + "\',\'" + passwordField.getText() + "\',\'Покупатель\');");
        query.executeUpdate();
        Query query1 = session.createNativeQuery("INSERT INTO customers(ogrn, inn, snp, firmtitle,city,phone,email,login)  VALUES (\'" + ogrnField.getText() + "\',\'" + innField.getText() + "\', \'" + surnameField.getText() + " " + nameField.getText() + " " + patroField.getText() + "\',\'" + firmTitleField.getText() +"\',\'" + cityField.getText() +"\',\'" + phoneField.getText() +"\',\'" + emailField.getText() + "\',\'" + loginField.getText() + "\');");
        query1.executeUpdate();
        tx.commit();
        session.close();
    }

    public void closeReg(ActionEvent actionEvent) {
        Stage stageTheEventSourceNodeBelongs = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        try {
            Parent reg = FXMLLoader.load(getClass().getResource("enter.fxml"));
            stageTheEventSourceNodeBelongs.setScene(new Scene(reg));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
