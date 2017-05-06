package view;

import db.CustomersEntity;
import db.OrdersEntity;
import db.UsersEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.query.Query;
import sessionFactory.HibernateSessionFactory;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class UserController implements Initializable {
    public MenuItem profileSettingsItem;
    public Button refreshOrdersButton;
    public Button newOrderButton;
    public TableView<OrdersEntity> ordersTable;
    public TableColumn<OrdersEntity, String> toyTitle;
    public TableColumn<OrdersEntity, String> toyCost;
    public TableColumn<OrdersEntity, Integer> amountOrder;
    public TableColumn<OrdersEntity, String> currencyOrder;
    public TableColumn<OrdersEntity, Date> dateExecution;
    public TableColumn<OrdersEntity, String> orderState;
    public ObservableList<OrdersEntity> orders = FXCollections.observableArrayList();

    public void changeProfileSettings(ActionEvent actionEvent) {
        Stage newChangeInfo = new Stage();
        try {
            Parent ch = FXMLLoader.load(getClass().getResource("changeInfo.fxml"));
            newChangeInfo.setScene(new Scene(ch));
            newChangeInfo.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void newOrder(ActionEvent actionEvent) {
        Stage newOrderStage = new Stage();
        try {
            Parent ch = FXMLLoader.load(getClass().getResource("newOrder.fxml"));
            newOrderStage.setScene(new Scene(ch));
            newOrderStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void refreshOrders(ActionEvent actionEvent) {
        selectOrders();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        toyTitle.setCellValueFactory(celldata -> celldata.getValue().toyTitleProperty());
        toyCost.setCellValueFactory(celldata -> celldata.getValue().orderCostProperty());
        amountOrder.setCellValueFactory(celldata -> celldata.getValue().productAmountProperty().asObject());
        currencyOrder.setCellValueFactory(celldata -> celldata.getValue().currencyProperty());
        dateExecution.setCellValueFactory(new PropertyValueFactory<>("executionDate"));
        orderState.setCellValueFactory(celldata -> celldata.getValue().orderStateProperty());
        ordersTable.setItems(orders);
    }

    public void selectOrders() {
        orders.clear();
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("FROM CustomersEntity WHERE login = :param");
        q.setParameter("param", Profile.getCurrent_login());
        List<CustomersEntity> customersList = q.list();
        Query query = session.createQuery("FROM OrdersEntity WHERE customer = :param");
        query.setParameter("param", customersList.get(0).getId());
        List<OrdersEntity> ordersList = query.list();
        orders.addAll(ordersList);
        tx.commit();
        session.close();
    }
}
