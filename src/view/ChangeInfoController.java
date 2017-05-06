package view;

import db.CustomersEntity;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import sessionFactory.HibernateSessionFactory;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ChangeInfoController implements Initializable{
    public TextField surnameField;
    public TextField nameField;
    public TextField patroField;
    public TextField firmTitleField;
    public TextField cityField;
    public TextField phoneField;
    public TextField emailField;
    public TextField passwordField;

    public void saveInfo(ActionEvent actionEvent) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Query updateCustomerQuery = session.createQuery("update CustomersEntity set snp = :snpParam, firmtitle = :firmTitleParam, city=:cityParam, phone = :phoneParam, email = :emailParam");
        updateCustomerQuery.setParameter("snpParam",surnameField.getText() + ' ' + nameField.getText() + ' ' + patroField.getText());
        updateCustomerQuery.setParameter("firmTitleParam", firmTitleField.getText());
        updateCustomerQuery.setParameter("cityParam", cityField.getText());
        updateCustomerQuery.setParameter("phoneParam", phoneField.getText());
        updateCustomerQuery.setParameter("emailParam", emailField.getText());
        Query updateUserPassword = session.createQuery("update UsersEntity set userPassword = :passwParam");
        updateUserPassword.setParameter("passwParam",passwordField.getText());
        updateCustomerQuery.executeUpdate();
        updateUserPassword.executeUpdate();
        tx.commit();
        session.close();
    }

    public void closeSettings(ActionEvent actionEvent) {
        Stage stageTheEventSourceNodeBelongs = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stageTheEventSourceNodeBelongs.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from CustomersEntity where login = :plogin");
        q.setParameter("plogin",Profile.getCurrent_login());
        List<CustomersEntity> customersList = q.list();
        CustomersEntity currentCustomer = customersList.get(0);
        String[] snp = currentCustomer.getSnp().split(" ");
        surnameField.setText(snp[0]);
        nameField.setText(snp[1]);
        patroField.setText(snp[2]);
        firmTitleField.setText(currentCustomer.getFirmtitle());
        cityField.setText(currentCustomer.getCity());
        phoneField.setText(currentCustomer.getPhone());
        emailField.setText(currentCustomer.getEmail());
        tx.commit();
        session.close();
    }
}
