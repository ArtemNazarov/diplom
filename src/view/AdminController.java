package view;

import db.*;
import dialogs.DialogManager;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;
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

public class AdminController implements Initializable {


    public TableView<SeatsEntity> seatsTable;
    public TableColumn<SeatsEntity, Integer> idSeatCol;
    public TableColumn<SeatsEntity, String> salaryCol;
    public TableColumn<SeatsEntity, String> seatCol;

    public TextField seatField;
    public TextField idSeatsField;
    public TextField salaryField;

    public TableView<UsersEntity> usersTable;
    public TableColumn<UsersEntity, String> loginCol;
    public TableColumn<UsersEntity, String> passwCol;
    public TableColumn<UsersEntity, String> roleCol;

    public TextField idEmployeeField;
    public TextField snpEmployeeField;
    public DatePicker birthDateEmployeeField;
    public TextField cityEmployeeField;
    public TextField addressEmplField;
    public TextField phoneEmployeeField;


    public TableView<EmployeesEntity> employeesTable;
    public TableColumn<EmployeesEntity, Integer> idEmployee;
    public TableColumn<EmployeesEntity, String> snpEmployee;
    public TableColumn<EmployeesEntity, String> birthDateEmployee;
    public TableColumn<EmployeesEntity, String> cityEmployee;
    public TableColumn<EmployeesEntity, String> addressEmployee;
    public TableColumn<EmployeesEntity, String> phoneEmployee;
    public TableColumn<EmployeesEntity, Integer> seatEmployeeCol;
    public TableColumn<EmployeesEntity, Integer> departmentEmployeeCol;
    public TableColumn<EmployeesEntity, String> loginEmployeeCol;
    public TableColumn<EmployeesEntity, Integer> institutionEmployeeCol;


    public TextField loginField;
    public PasswordField passwordField;
    public TextField roleField;

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
    public MenuItem exitSystemItem;
    public TextField seatEmployeeField;
    public TextField institutionField;
    public TextField departmentEmployeeField;
    public TextField loginEmployeeField;
    SimpleStringProperty roleProperty = new SimpleStringProperty();



    ObservableList<SeatsEntity> seatsList = FXCollections.observableArrayList();
    ObservableList<UsersEntity> usersList = FXCollections.observableArrayList();
    ObservableList<EmployeesEntity> employeesList = FXCollections.observableArrayList();
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

    public void initializeSupplierCols(){
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
    }

    public void initializeEmployeeCols(){
        idEmployee.setCellValueFactory(celldata -> celldata.getValue().idProperty().asObject());
        snpEmployee.setCellValueFactory(celldata -> celldata.getValue().snpProperty());
        birthDateEmployee.setCellValueFactory(param -> {
            SimpleStringProperty property = new SimpleStringProperty();
            property.setValue(param.getValue().getBirthdate().toString());
            return property;
        });
        cityEmployee.setCellValueFactory(celldata -> celldata.getValue().cityProperty());
        addressEmployee.setCellValueFactory(celldata -> celldata.getValue().addressProperty());
        phoneEmployee.setCellValueFactory(celldata -> celldata.getValue().phoneProperty());
        seatEmployeeCol.setCellValueFactory(celldata -> celldata.getValue().seatProperty().asObject());
        departmentEmployeeCol.setCellValueFactory(celldata -> celldata.getValue().departmentProperty().asObject());
        institutionEmployeeCol.setCellValueFactory(celldata -> celldata.getValue().institutionProperty().asObject());
        loginEmployeeCol.setCellValueFactory(celldata -> celldata.getValue().loginProperty());
        employeesTable.setItems(employeesList);
    }

    public void initializeOrderCols(){
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
    }

    public void initializeSeatCols(){
        idSeatCol.setCellValueFactory(celldata -> celldata.getValue().idProperty().asObject());
        salaryCol.setCellValueFactory(celldata -> celldata.getValue().salaryProperty());
        seatCol.setCellValueFactory(celldata -> celldata.getValue().seatProperty());
        seatsTable.setItems(seatsList);
    }

    public void initializeUserCols(){
        loginCol.setCellValueFactory(celldata -> celldata.getValue().userLoginProperty());
        passwCol.setCellValueFactory(celldata -> celldata.getValue().userPasswordProperty());
        roleCol.setCellValueFactory(param -> {
            roleProperty.setValue(param.getValue().getUserRole().getRole());
            return roleProperty;
        });
        usersTable.setItems(usersList);
    }

    public void initializeMaterialCols(){
        idMaterialCol.setCellValueFactory(celldata -> celldata.getValue().idProperty().asObject());
        materialCol.setCellValueFactory(celldata -> celldata.getValue().materialProperty());
        materialsTable.setItems(materialsList);
    }

    public void initializeEquipmentCols(){
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
    }

    public void initializeProcurementCols(){
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
    }

    public void initializeToyProduceCols(){
        toyProduceCol.setCellValueFactory(celldata -> celldata.getValue().toyProperty().asObject());
        eqProduceCol.setCellValueFactory(celldata -> celldata.getValue().equipmentProperty().asObject());
        orderProduceCol.setCellValueFactory(celldata -> celldata.getValue().currentOrderProperty().asObject());
        amountMaterialProduceCol.setCellValueFactory(celldata -> celldata.getValue().materialCountProperty().asObject());
        produceTable.setItems(produceList);
    }


    public void initializeSelectionEmployees(){
        employeesTable.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            if (employeesTable.getSelectionModel().getSelectedItem() != null) {
                idEmployeeField.setText(newValue.idProperty().getValue().toString());
                snpEmployeeField.setText(newValue.snpProperty().getValue());
                cityEmployeeField.setText(newValue.getCity());
                addressEmplField.setText(newValue.getAddress());
                phoneEmployeeField.setText(newValue.getPhone());
//                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//                LocalDate localDate = LocalDate.parse(newValue.getBirthdate().toString(), formatter);
                birthDateEmployeeField.setValue(newValue.getBirthdate());
                seatEmployeeField.setText(newValue.seatProperty().getValue().toString());
                departmentEmployeeField.setText(newValue.departmentProperty().getValue().toString());
                institutionField.setText(newValue.institutionProperty().getValue().toString());
                loginEmployeeField.setText(newValue.loginProperty().getValue());
            }
        });
    }

    public void initializeSelectionSuppliers(){
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

    public void initializeSelectionOrders(){
        ordersTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (ordersTable.getSelectionModel().getSelectedItem() != null){
                idOrderField.setText(newValue.idProperty().getValue().toString());
                toyTitleOrderField.setText(newValue.toyTitleProperty().getValue());
                toyCostOrderField.setText(newValue.orderCostProperty().getValue());
                currencyOrderField.setText(newValue.currencyProperty().getValue());
                amountOrderField.setText(newValue.productAmountProperty().getValue().toString());
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate localDate = LocalDate.parse(newValue.getExecutionDate().toString(), formatter);
                orderStateField.setText(newValue.orderStateProperty().getValue());
                dateExecField.setValue(localDate);
            }
        });
    }

    public void initializeSelectionSeats(){
        seatsTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (seatsTable.getSelectionModel().getSelectedItem() != null){
                idSeatsField.setText(newValue.idProperty().getValue().toString());
                seatField.setText(newValue.seatProperty().getValue());
                salaryField.setText(newValue.salaryProperty().getValue());
            }
        });
    }

    public void initializeSelectionEquipment(){
        equipmentTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (equipmentTable.getSelectionModel().getSelectedItem() != null){
                idEqField.setText(newValue.idProperty().getValue().toString());
                eqTitleField.setText(newValue.titleProperty().getValue());
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate localDate = LocalDate.parse(newValue.getManufactureDate().toString(), formatter);
                dateManufactureField.setValue(localDate);

            }
        });
    }

    public void initializeSelectionUsers(){
        usersTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (usersTable.getSelectionModel().getSelectedItem() != null) {
                loginField.setText(newValue.userLoginProperty().getValue());
                passwordField.setText(newValue.userPasswordProperty().getValue());
                roleField.setText(newValue.getUserRole().getRole());
            }
        });

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializeSeatCols();
        initializeUserCols();
        initializeSupplierCols();
        initializeEmployeeCols();
        initializeOrderCols();
        initializeMaterialCols();
        initializeEquipmentCols();
        initializeProcurementCols();
        initializeToyProduceCols();

        initializeSelectionEmployees();
        initializeSelectionSuppliers();
        initializeSelectionOrders();
        initializeSelectionSeats();
        initializeSelectionEquipment();
        initializeSelectionUsers();
    }

    public void changeSeats(ActionEvent actionEvent) {

        if (!idSeatsField.getText().equals("")) {
            if (!seatField.getText().equals("")) {
                if (!salaryField.getText().equals("")) {
                    updateSeat();
                } else {
                    DialogManager.showErrorDialog("Введите зарплату");

                }
            } else {
                DialogManager.showErrorDialog("Введите должность");
            }
        } else {
            DialogManager.showErrorDialog("Введите id");
        }

    }

    public void updateSeat() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("update SeatsEntity SET salary = :salaryParam, seat = :seatParam WHERE id = :idParam");
        query.setParameter("salaryParam", salaryField.getText());
        query.setParameter("seatParam", seatField.getText());
        query.setParameter("idParam", idSeatsField.getText());
//        Query nativeQuery = session.createNativeQuery("UPDATE seats SET salary = " + salaryField.getText() + ", seat = \'" + seatField.getText() + "\' WHERE id = " + idSeatsField.getText());
//        nativeQuery.executeUpdate();
        query.executeUpdate();
        selectSeats(session);
        Notifications.create().title("wfe").text("wef").position(Pos.CENTER).showConfirm();
        tx.commit();
        session.close();
    }

    public void addSeat(ActionEvent actionEvent) {

    }

    public void deleteSeat(ActionEvent actionEvent) {

    }

    public void changeUsers(ActionEvent actionEvent) {

    }

    public void updateUsers(ActionEvent actionEvent) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("from UsersEntity ");
        List<UsersEntity> users = query.list();
        usersList.clear();
        usersList.addAll(users);
        tx.commit();
        session.close();
    }

    public void addUser(ActionEvent actionEvent) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createNativeQuery("INSERT INTO users VALUES (\'" + loginField.getText() + "\',\'" + passwordField.getText() + "\',\'" + roleField.getText() + "\');");
        query.executeUpdate();
        tx.commit();
        session.close();
    }

    public void deleteUser(ActionEvent actionEvent) {

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
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("from ProcurementsEntity ");
        List<ProcurementsEntity> procurements = query.list();
        procurementsList.clear();
        procurementsList.addAll(procurements);
        tx.commit();
        session.close();
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

    public void deleteEquip(ActionEvent actionEvent) {
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

    public void deleteMaterial(ActionEvent actionEvent) {

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

    public void addEmployee(ActionEvent actionEvent) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createNativeQuery("INSERT INTO employees(snp,birthdate,city,address,phone,seat,department,institution, login) VALUES (\'"+ snpEmployeeField.getText() +"\',\'"+ birthDateEmployeeField.getValue().toString()+"\',\'" + cityEmployeeField.getText() +"\',\'" + addressEmplField.getText()  +"\',\'" + phoneEmployeeField.getText() +"\',\'" + seatEmployeeField.getText() + "\',\'" + departmentEmployeeField.getText() + "\',\'" + institutionField.getText() + "\',\'" + loginField.getText() + "\');");
        query.executeUpdate();
        tx.commit();
        session.close();
    }

    public void changeEmployee(ActionEvent actionEvent) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("update EmployeesEntity SET snp= :snpParam, city = :city, address = :address, phone = :phone, birthdate= :birthDate, seat = :seat, department = :dep, institution = :inst WHERE id = :id");
        query.setParameter("id", Integer.parseInt(idEmployeeField.getText()));
        query.setParameter("snpParam", snpEmployeeField.getText());
        query.setParameter("birthDate", birthDateEmployeeField.getValue());
        query.setParameter("city", cityEmployeeField.getText());
        query.setParameter("address", addressEmplField.getText());
        query.setParameter("phone", phoneEmployeeField.getText());
        query.setParameter("inst", Integer.parseInt(institutionField.getText()));
        query.setParameter("dep", Integer.parseInt(departmentEmployeeField.getText()) );
        query.setParameter("seat", Integer.parseInt(seatEmployeeField.getText()) );
        query.executeUpdate();
        selectSeats(session);
        tx.commit();
        session.close();
    }

    public void getEmployees(ActionEvent actionEvent) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("from EmployeesEntity ");
        List<EmployeesEntity> employees = query.list();
        employeesList.clear();
        employeesList.addAll(employees);
        tx.commit();
        session.close();
    }

    public void deleteEmployee(ActionEvent actionEvent) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("delete from EmployeesEntity where id = :id");
        query.setParameter("id",idEmployeeField.getText());
        query.executeUpdate();
        selectSeats(session);
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
