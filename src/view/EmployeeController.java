package view;

import db.*;
import dialogs.DialogManager;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import sessionFactory.HibernateSessionFactory;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;

public class EmployeeController implements Initializable {


    public TextField idOrderField;
    public TextField toyTitleOrderField;
    public TextField toyCostOrderField;
    public TextField currencyOrderField;
    public TextField amountOrderField;
    public TextField orderStateField;
    public DatePicker dateExecField;


    public TableView<OrdersEntity> ordersTable;
    public TableColumn<OrdersEntity, Integer> idOrderCol;
    public TableColumn<OrdersEntity, String> toyTitleOrderCol;
    public TableColumn<OrdersEntity, String> toyCostOrderCol;
    public TableColumn<OrdersEntity, String> currencyOrderCol;
    public TableColumn<OrdersEntity, Integer> amountOrderCol;
    public TableColumn<OrdersEntity, String> orderStateCol;
    public TableColumn<OrdersEntity, String> dateExecutionOrderCol;

    public TextField idProcurementField;
    public TextField dateProcurement;
    public TextField amountProcurement;
    public TextField supplierField;
    public TextField materialProcField;

    public TableView<ProcurementsEntity> procurementsTable;
    public TableColumn<ProcurementsEntity, Integer> idProcurementCol;
    public TableColumn<ProcurementsEntity, String> dateExecProcurCol;
    public TableColumn<ProcurementsEntity, Integer> amountMaterialCol;
    public TableColumn<ProcurementsEntity, Integer> supplierProcurementCol;
    public TableColumn<ProcurementsEntity, Integer> materialProcurementCol;

    public TextField idSupplierField;
    public TextField ogrnSupplierField;
    public TextField innSupplierField;
    public TextField firmTitleSupplierField;
    public TextField contractValidityField;
    public DatePicker contractDateField;

    public TableView<SuppliersEntity> suppliersTable;
    public TableColumn<SuppliersEntity, Integer> idSupplierCol;
    public TableColumn<SuppliersEntity, String> ogrnSupplierCol;
    public TableColumn<SuppliersEntity, String> innSupplierCol;
    public TableColumn<SuppliersEntity, String> firmTitleFieldSupplierCol;
    public TableColumn<SuppliersEntity, Integer> contractValidityCol;
    public TableColumn<SuppliersEntity, String> contractDateCol;

    public TextField idEqField;
    public TextField eqTitleField;
    public DatePicker dateManufactureField;

    public TableView<EquipmentEntity> equipmentTable;
    public TableColumn<EquipmentEntity, Integer> idEquipCol;
    public TableColumn<EquipmentEntity, String> eqTitleCol;
    public TableColumn<EquipmentEntity, String> manufactureDateCol;
    public TableColumn<EquipmentEntity, String> purposeCol;
    public TableColumn<EquipmentEntity, Integer> eqTypeCol;

    public TextField idMaterialField;
    public TextField materialTitleField;

    public TableView<MaterialsEntity> materialsTable;
    public TableColumn<MaterialsEntity, Integer> idMaterialCol;
    public TableColumn<MaterialsEntity, String> materialCol;

    public TextField employeeProduceField;
    public TextField toyProduceField;
    public TextField equipProduceField;
    public TextField orderNumberField;
    public TextField materialAmountField;

    public TableView<ToyProduceEntity> produceTable;
    public TableColumn<ToyProduceEntity, Integer> toyProduceCol;
    public TableColumn<ToyProduceEntity, Integer> eqProduceCol;
    public TableColumn<ToyProduceEntity, Integer> orderProduceCol;
    public TableColumn<ToyProduceEntity, Integer> amountMaterialProduceCol;

    ObservableList<SeatsEntity> seatsList = FXCollections.observableArrayList();
    ObservableList<ProcurementsEntity> procurementsList = FXCollections.observableArrayList();
    ObservableList<SuppliersEntity> suppliersList = FXCollections.observableArrayList();
    ObservableList<OrdersEntity> ordersList = FXCollections.observableArrayList();
    ObservableList<MaterialsEntity> materialsList = FXCollections.observableArrayList();
    ObservableList<EquipmentEntity> equipmentList = FXCollections.observableArrayList();
    ObservableList<ToyProduceEntity> produceList = FXCollections.observableArrayList();


    public void getSeats(ActionEvent actionEvent) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        selectSeats(session);
        session.close();
    }


    public void selectSeats(Session session) {
        Query q = session.createQuery("from SeatsEntity");
        List<SeatsEntity> list = q.list();
        seatsList.clear();
        seatsList.addAll(list);
    }




    @Override
    public void initialize(URL location, ResourceBundle resources) {
        idSupplierCol.setCellValueFactory(celldata -> celldata.getValue().idProperty().asObject());
        ogrnSupplierCol.setCellValueFactory(celldata -> celldata.getValue().ogrnProperty());
        innSupplierCol.setCellValueFactory(celldata -> celldata.getValue().innProperty());
        firmTitleFieldSupplierCol.setCellValueFactory(celldata -> celldata.getValue().firmtitleProperty());
        contractValidityCol.setCellValueFactory(celldata -> celldata.getValue().contractValidityProperty().asObject());
        contractDateCol.setCellValueFactory(param -> {
            SimpleStringProperty property = new SimpleStringProperty();
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            property.setValue(dateFormat.format(param.getValue().getContractSignDate()));
            return property;
        });
        suppliersTable.setItems(suppliersList);

        idOrderCol.setCellValueFactory(celldata -> celldata.getValue().idProperty().asObject());
        toyTitleOrderCol.setCellValueFactory(celldata -> celldata.getValue().toyTitleProperty());
        toyCostOrderCol.setCellValueFactory(celldata -> celldata.getValue().orderCostProperty());
        currencyOrderCol.setCellValueFactory(celldata -> celldata.getValue().currencyProperty());
        amountOrderCol.setCellValueFactory(celldata -> celldata.getValue().productAmountProperty().asObject());
        orderStateCol.setCellValueFactory(celldata -> celldata.getValue().orderStateProperty());
        dateExecutionOrderCol.setCellValueFactory(param -> {
            SimpleStringProperty property = new SimpleStringProperty();
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            property.setValue(dateFormat.format(param.getValue().getExecutionDate()));
            return property;
        });
        ordersTable.setItems(ordersList);

        idProcurementCol.setCellValueFactory(celldata -> celldata.getValue().idProperty().asObject());
        dateExecProcurCol.setCellValueFactory(param -> {
            SimpleStringProperty property = new SimpleStringProperty();
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            property.setValue(dateFormat.format(param.getValue().getProcurementDate()));
            return property;
        });

        amountMaterialCol.setCellValueFactory(celldata -> celldata.getValue().materialCountProperty().asObject());
        supplierProcurementCol.setCellValueFactory(celldata -> celldata.getValue().supplierProperty().asObject());
        materialProcurementCol.setCellValueFactory(celldata -> celldata.getValue().materialProperty().asObject());
        procurementsTable.setItems(procurementsList);

        idEquipCol.setCellValueFactory(celldata -> celldata.getValue().idProperty().asObject());
        eqTitleCol.setCellValueFactory(celldata -> celldata.getValue().titleProperty());
        manufactureDateCol.setCellValueFactory(param -> {
            SimpleStringProperty property = new SimpleStringProperty();
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            property.setValue(dateFormat.format(param.getValue().getManufactureDate()));
            return property;
        });
        purposeCol.setCellValueFactory(celldata -> celldata.getValue().eqFunctionProperty());
        eqTypeCol.setCellValueFactory(celldata -> celldata.getValue().eqTypeProperty().asObject());
        equipmentTable.setItems(equipmentList);

        idMaterialCol.setCellValueFactory(celldata -> celldata.getValue().idProperty().asObject());
        materialCol.setCellValueFactory(celldata -> celldata.getValue().materialProperty());
        materialsTable.setItems(materialsList);

        toyProduceCol.setCellValueFactory(celldata -> celldata.getValue().toyProperty().asObject());
        eqProduceCol.setCellValueFactory(celldata -> celldata.getValue().equipmentProperty().asObject());
        orderProduceCol.setCellValueFactory(celldata -> celldata.getValue().currentOrderProperty().asObject());
        amountMaterialProduceCol.setCellValueFactory(celldata -> celldata.getValue().materialCountProperty().asObject());
        produceTable.setItems(produceList);

        suppliersTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (suppliersTable.getSelectionModel().getSelectedItem() != null) {
                idSupplierField.setText(newValue.idProperty().getValue().toString());
                ogrnSupplierField.setText(newValue.ogrnProperty().getValue());
                innSupplierField.setText(newValue.innProperty().getValue());
                firmTitleSupplierField.setText(newValue.firmtitleProperty().getValue());
                contractValidityField.setText(newValue.contractValidityProperty().getValue().toString());
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate localDate = LocalDate.parse(newValue.getContractSignDate().toString(), formatter);
                contractDateField.setValue(localDate);
            }
        });

    }


    public void changePassword(ActionEvent actionEvent) {
        try {
            Parent main = FXMLLoader.load(getClass().getResource("changePassword.fxml"));
            Scene scene = new Scene(main);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            DialogManager.showErrorDialog("Не найдена форма, отвечающая за изменение пароля!");
        }

    }


    public void addOrder(ActionEvent actionEvent) {
    }

    public void changeOrders(ActionEvent actionEvent) {
    }

    public void deleteOrder(ActionEvent actionEvent) {
    }

    public void getOrders(ActionEvent actionEvent) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("from OrdersEntity ");
        List<OrdersEntity> orders = query.list();
        ordersList.clear();
        ordersList.addAll(orders);
        tx.commit();
        session.close();
    }

    public void changeOrder(ActionEvent actionEvent) {

    }

    public void addProcurement(ActionEvent actionEvent) {
    }

    public void changeProcurement(ActionEvent actionEvent) {
    }

    public void getProcurements(ActionEvent actionEvent) {
    }

    public void deleteProcurement(ActionEvent actionEvent) {
    }

    public void addSupplier(ActionEvent actionEvent) {
    }

    public void updateSuppliers(ActionEvent actionEvent) {
    }

    public void getSuppliers(ActionEvent actionEvent) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("from SuppliersEntity ");
        List<SuppliersEntity> suppliers = query.list();
        suppliersList.clear();
        suppliersList.addAll(suppliers);
        tx.commit();
        session.close();
    }

    public void deleteSupplier(ActionEvent actionEvent) {
    }

    public void addEquipment(ActionEvent actionEvent) {
    }

    public void changeEquipment(ActionEvent actionEvent) {
    }

    public void getEquipment(ActionEvent actionEvent) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("from EquipmentEntity ");
        List<EquipmentEntity> equipment = query.list();
        equipmentList.clear();
        equipmentList.addAll(equipment);
        tx.commit();
        session.close();
    }


    public void addMaterial(ActionEvent actionEvent) {

    }

    public void changeMaterial(ActionEvent actionEvent) {

    }

    public void getMaterials(ActionEvent actionEvent) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("from MaterialsEntity ");
        List<MaterialsEntity> materials = query.list();
        materialsList.clear();
        materialsList.addAll(materials);
        tx.commit();
        session.close();
    }


    public void addProduce(ActionEvent actionEvent) {

    }

    public void changeProduce(ActionEvent actionEvent) {

    }

    public void deleteProduce(ActionEvent actionEvent) {

    }

    public void getProduce(ActionEvent actionEvent) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("from ToyProduceEntity ");
        List<ToyProduceEntity> produce = query.list();
        produceList.clear();
        produceList.addAll(produce);
        tx.commit();
        session.close();
    }

    public void exitSystem(ActionEvent actionEvent) {
        Stage stage = (Stage) idSupplierField.getScene().getWindow();
        Profile.setCurrent_userRole(null);
        Profile.setCurrent_password(null);
        Profile.setCurrent_login(null);
        try {
            Parent reg = FXMLLoader.load(getClass().getResource("enter.fxml"));
            stage.setScene(new Scene(reg));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
