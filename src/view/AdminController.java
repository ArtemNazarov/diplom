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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    public TableColumn<EmployeesEntity, Integer> idEmployeeCol;
    public TableColumn<EmployeesEntity, String> snpEmployeeCol;
    public TableColumn<EmployeesEntity, String> birthDateEmployeeCol;
    public TableColumn<EmployeesEntity, String> cityEmployeeCol;
    public TableColumn<EmployeesEntity, String> addressEmployeeCol;
    public TableColumn<EmployeesEntity, String> phoneEmployeeCol;
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
    public TextField purposeField;
    public TextField equipmentTypeField;

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
    public TableColumn<ToyProduceEntity, Integer> employeeProduceCol;

    public MenuItem exitSystemItem;
    public TextField seatEmployeeField;
    public TextField institutionField;
    public TextField departmentEmployeeField;
    public TextField loginEmployeeField;

    public TableView<CustomersEntity> customersTable;
    public TableColumn<CustomersEntity, Integer> idCustomersCol;
    public TableColumn<CustomersEntity, String> snpCustomersCol;
    public TableColumn<CustomersEntity, String> orgnCustomersCol;
    public TableColumn<CustomersEntity, String> innCustomersCol;
    public TableColumn<CustomersEntity, String> firmCustomersCol;
    public TableColumn<CustomersEntity, String> cityCustomersCol;
    public TableColumn<CustomersEntity, String> phoneCustomersCol;
    public TableColumn<CustomersEntity, String> emailCustomersCol;
    public TableColumn<CustomersEntity, String> loginCustomersCol;

    public TableView<BanksEntity> bankTable;
    public TableColumn<BanksEntity, Integer> idBankCol;
    public TableColumn<BanksEntity, String> bankCol;

    public TextField idBankField;
    public TextField bankField;

    public TextField snpCustomerField;
    public TextField innCustomerField;
    public TextField idCustomerField;
    public TextField ogrnCustomerField;
    public TextField cityCustomerField;
    public TextField firmCustomerField;
    public TextField emailCustomerField;
    public TextField phoneCustomerField;
    public TextField loginCustomerField;


    public TableView<AccountsEntity> accountsTable;
    public TableColumn<AccountsEntity, Integer> idAccountCol;
    public TableColumn<AccountsEntity, String> numberAccountsCol;
    public TableColumn<AccountsEntity, Integer> bankAccountsCol;

    public TextField idAccountField;
    public TextField numberAccountField;
    public TextField bankAccountField;

    public TableView<PaymentsEntity> paymentsTable;
    public TableColumn<PaymentsEntity, Integer> idPaymentCol;
    public TableColumn<PaymentsEntity, String> sumPaymentCol;
    public TableColumn<PaymentsEntity, Integer> supplierPaymentCol;
    public TableColumn<PaymentsEntity, Integer> accountPaymentCol;


    public TableView<EquipmentTypesEntity> equipmentTypesTable;
    public TableColumn<EquipmentTypesEntity, Integer> idEqTypeCol;
    public TableColumn<EquipmentTypesEntity, String> eqTypeTitleCol;

    public TableView<ProjectsEntity> projectsTable;
    public TableColumn<ProjectsEntity, Integer> idProjectCol;
    public TableColumn<ProjectsEntity, String> titleProjectCol;
    public TableColumn<ProjectsEntity, String> devProjectCol;
    public TableColumn<ProjectsEntity, Integer> materialProjectCol;
    public TableColumn<ProjectsEntity, Integer> toyTypeProjectCol;

    public TextField idProjectField;
    public TextField titleProjectField;
    public TextField devProjectField;
    public TextField materialProjectField;
    public TextField toyTypeProjectsField;

    public TableView<ToysEntity> toysTable;
    public TableColumn<ToysEntity, Integer> idToyCol;
    public TableColumn<ToysEntity, String> barcodeToyCol;
    public TableColumn<ToysEntity, String> toyTitleCol;
    public TableColumn<ToysEntity, String> ageCategorytoyCol;
    public TableColumn<ToysEntity, Integer> weightToyCol;
    public TableColumn<ToysEntity, Integer> detailsAmountToyCol;
    public TableColumn<ToysEntity, Integer> typeToyCol;
    public TableColumn<ToysEntity, Integer> materialToyCol;

    public TextField idToyField;
    public TextField barcodeToyField;
    public TextField titleToyField;
    public TextField cathegoryToyField;
    public TextField weightToyField;
    public TextField detailsAmountToyField;
    public TextField toyTypeField;
    public TextField materialToyField;

    public TableView<ToyTypesEntity> toyTypesTable;
    public TableColumn<ToyTypesEntity, Integer> idToyTypeCol;
    public TableColumn<ToyTypesEntity, String> toyTypeCol;

    public TextField idPaymentField;
    public TextField sumPaymentField;
    public TextField supplierPaymentField;
    public TextField accNumberPaymentField;

    public TextField idToyTypeField;
    public TextField toyTypeTitleField;


    ObservableList<SeatsEntity> seatsList = FXCollections.observableArrayList();
    ObservableList<UsersEntity> usersList = FXCollections.observableArrayList();
    ObservableList<EmployeesEntity> employeesList = FXCollections.observableArrayList();
    ObservableList<ProcurementsEntity> procurementsList = FXCollections.observableArrayList();
    ObservableList<SuppliersEntity> suppliersList = FXCollections.observableArrayList();
    ObservableList<OrdersEntity> ordersList = FXCollections.observableArrayList();
    ObservableList<MaterialsEntity> materialsList = FXCollections.observableArrayList();
    ObservableList<EquipmentEntity> equipmentList = FXCollections.observableArrayList();
    ObservableList<ToyProduceEntity> produceList = FXCollections.observableArrayList();
    ObservableList<AccountsEntity> accountsList = FXCollections.observableArrayList();
    ObservableList<BanksEntity> banksList = FXCollections.observableArrayList();
    ObservableList<PaymentsEntity> paymentsList = FXCollections.observableArrayList();
    ObservableList<CustomersEntity> customersList = FXCollections.observableArrayList();
    ObservableList<ProjectsEntity> projectsList = FXCollections.observableArrayList();
    ObservableList<EquipmentTypesEntity> equipmentTypesList = FXCollections.observableArrayList();
    ObservableList<ToyTypesEntity> toyTypesList = FXCollections.observableArrayList();
    ObservableList<ToysEntity> toysList = FXCollections.observableArrayList();


    public void initializeSupplierCols() {
        Map<String, TableColumn> colsMap = new HashMap<>();
        colsMap.put("id", idSupplierCol);
        colsMap.put("ogrn", ogrnSupplierCol);
        colsMap.put("inn", innSupplierCol);
        colsMap.put("firmTitle", firmTitleFieldSupplierCol);
        colsMap.put("contractValidity", contractValidityCol);
        colsMap.put("contractDate", contractDateCol);
        UICreator<SuppliersEntity> uiCreator = new UICreator<>(SuppliersEntity.class);
        colsMap = uiCreator.initializeSupplierCols(colsMap);
        idSupplierCol = colsMap.get("id");
        ogrnSupplierCol = colsMap.get("ogrn");
        innSupplierCol = colsMap.get("inn");
        firmTitleFieldSupplierCol = colsMap.get("firmTitle");
        contractValidityCol = colsMap.get("contractValidity");
        contractDateCol = colsMap.get("contractDate");
        suppliersTable.setItems(suppliersList);
    }


    public void initializeEmployeeCols() {
        Map<String, TableColumn> colsMap = new HashMap<>();
        colsMap.put("id", idEmployeeCol);
        colsMap.put("snp", snpEmployeeCol);
        colsMap.put("birthDate", birthDateEmployeeCol);
        colsMap.put("city", cityEmployeeCol);
        colsMap.put("address", addressEmployeeCol);
        colsMap.put("phone", phoneEmployeeCol);
        colsMap.put("seat", seatEmployeeCol);
        colsMap.put("department", departmentEmployeeCol);
        colsMap.put("institution", institutionEmployeeCol);
        colsMap.put("login", loginEmployeeCol);
        UICreator<EmployeesEntity> uiCreator = new UICreator<>(EmployeesEntity.class);
        colsMap = uiCreator.initializeEmployeeCols(colsMap);
        idEmployeeCol = colsMap.get("id");
        snpEmployeeCol = colsMap.get("snp");
        birthDateEmployeeCol = colsMap.get("birthDate");
        cityEmployeeCol = colsMap.get("city");
        addressEmployeeCol = colsMap.get("address");
        phoneEmployeeCol = colsMap.get("phone");
        seatEmployeeCol = colsMap.get("seat");
        departmentEmployeeCol = colsMap.get("department");
        institutionEmployeeCol = colsMap.get("institution");
        loginEmployeeCol = colsMap.get("login");
        employeesTable.setItems(employeesList);

    }

    public void initializeOrderCols() {
        Map<String, TableColumn> colsMap = new HashMap<>();
        colsMap.put("id", idOrderCol);
        colsMap.put("toyTitle", toyTitleOrderCol);
        colsMap.put("toyCost", toyCostOrderCol);
        colsMap.put("currency", currencyOrderCol);
        colsMap.put("amount", amountOrderCol);
        colsMap.put("state", orderStateCol);
        colsMap.put("execdate", dateExecutionOrderCol);
        UICreator<OrdersEntity> uiCreator = new UICreator<>(OrdersEntity.class);
        colsMap = uiCreator.initializeOrderCols(colsMap);
        idOrderCol = colsMap.get("id");
        toyTitleOrderCol = colsMap.get("toyTitle");
        toyCostOrderCol = colsMap.get("toyCost");
        currencyOrderCol = colsMap.get("currency");
        amountOrderCol = colsMap.get("amount");
        orderStateCol = colsMap.get("state");
        dateExecutionOrderCol = colsMap.get("execdate");
        ordersTable.setItems(ordersList);
    }

    public void initializeSeatCols() {
        Map<String, TableColumn> colsMap = new HashMap<>();
        colsMap.put("id", idSeatCol);
        colsMap.put("salary", salaryCol);
        colsMap.put("seat", seatCol);
        UICreator<SeatsEntity> uiCreator = new UICreator<>(SeatsEntity.class);
        colsMap = uiCreator.initializeSeatCols(colsMap);
        idSeatCol = colsMap.get("id");
        salaryCol = colsMap.get("salary");
        seatCol = colsMap.get("seat");
        seatsTable.setItems(seatsList);
    }

    public void initializeUserCols() {
        Map<String, TableColumn> colsMap = new HashMap<>();
        colsMap.put("login", loginCol);
        colsMap.put("password", passwCol);
        colsMap.put("role", roleCol);
        UICreator<UsersEntity> uiCreator = new UICreator<>(UsersEntity.class);
        colsMap = uiCreator.initializeUserCols(colsMap);
        loginCol = colsMap.get("login");
        passwCol = colsMap.get("password");
        roleCol = colsMap.get("role");
        usersTable.setItems(usersList);
    }

    public void initializeMaterialCols() {
        Map<String, TableColumn> colsMap = new HashMap<>();
        colsMap.put("id", idMaterialCol);
        colsMap.put("material", materialCol);
        UICreator<MaterialsEntity> uiCreator = new UICreator<>(MaterialsEntity.class);
        colsMap = uiCreator.initializeMaterialCols(colsMap);
        idMaterialCol = colsMap.get("id");
        materialCol = colsMap.get("material");
        materialsTable.setItems(materialsList);
    }

    public void initializeEquipmentCols() {
        Map<String, TableColumn> colsMap = new HashMap<>();
        colsMap.put("id", idEquipCol);
        colsMap.put("title", eqTitleCol);
        colsMap.put("manufacture", manufactureDateCol);
        colsMap.put("purpose", purposeCol);
        colsMap.put("type", eqTypeCol);
        UICreator<EquipmentEntity> uiCreator = new UICreator<>(EquipmentEntity.class);
        colsMap = uiCreator.initializeEquipmentCols(colsMap);
        idEquipCol = colsMap.get("id");
        eqTitleCol = colsMap.get("title");
        manufactureDateCol = colsMap.get("manufacture");
        purposeCol = colsMap.get("purpose");
        eqTypeCol = colsMap.get("type");
        equipmentTable.setItems(equipmentList);
    }

    public void initializeProcurementCols() {
        Map<String, TableColumn> colsMap = new HashMap<>();
        colsMap.put("id", idProcurementCol);
        colsMap.put("date", dateExecProcurCol);
        colsMap.put("amount", amountMaterialCol);
        colsMap.put("supplier", supplierProcurementCol);
        colsMap.put("material", materialProcurementCol);
        UICreator<ProcurementsEntity> uiCreator = new UICreator<>(ProcurementsEntity.class);
        colsMap = uiCreator.initializeProcurementCols(colsMap);
        idProcurementCol = colsMap.get("id");
        dateExecProcurCol = colsMap.get("date");
        amountMaterialCol = colsMap.get("amount");
        supplierProcurementCol = colsMap.get("supplier");
        materialProcurementCol = colsMap.get("material");
        procurementsTable.setItems(procurementsList);
    }

    public void initializeToyProduceCols() {
        Map<String, TableColumn> colsMap = new HashMap<>();
        colsMap.put("toy", toyProduceCol);
        colsMap.put("eq", eqProduceCol);
        colsMap.put("order", orderProduceCol);
        colsMap.put("amount", amountMaterialProduceCol);
        UICreator<ToyProduceEntity> uiCreator = new UICreator<>(ToyProduceEntity.class);
        colsMap = uiCreator.initializeToyProduceCols(colsMap);
        toyProduceCol.setCellValueFactory(celldata -> celldata.getValue().toyProperty().asObject());
        eqProduceCol.setCellValueFactory(celldata -> celldata.getValue().equipmentProperty().asObject());
        orderProduceCol.setCellValueFactory(celldata -> celldata.getValue().currentOrderProperty().asObject());
        amountMaterialProduceCol.setCellValueFactory(celldata -> celldata.getValue().materialCountProperty().asObject());
        produceTable.setItems(produceList);
    }

    public void initializeAccountsCols() {
        Map<String, TableColumn> colsMap = new HashMap<>();
        colsMap.put("id", idAccountCol);
        colsMap.put("number", numberAccountsCol);
        colsMap.put("bank", bankAccountsCol);
        UICreator<AccountsEntity> uiCreator = new UICreator<>(AccountsEntity.class);
        colsMap = uiCreator.initializeAccountsCols(colsMap);
        idAccountCol = colsMap.get("id");
        numberAccountsCol = colsMap.get("number");
        bankAccountsCol = colsMap.get("number");
        accountsTable.setItems(accountsList);
    }


    public void initializeBanksCols() {
        Map<String, TableColumn> colsMap = new HashMap<>();
        colsMap.put("id", idBankCol);
        colsMap.put("bank", bankCol);
        UICreator<BanksEntity> uiCreator = new UICreator<>(BanksEntity.class);
        colsMap = uiCreator.initializeBankCols(colsMap);
        idBankCol = colsMap.get("id");
        bankCol = colsMap.get("bank");
        bankTable.setItems(banksList);

    }

    public void initializePaymentsCols() {
        Map<String, TableColumn> colsMap = new HashMap<>();
        colsMap.put("id", idPaymentCol);
        colsMap.put("sum", sumPaymentCol);
        colsMap.put("supplier", supplierPaymentCol);
        colsMap.put("account", accountPaymentCol);
        UICreator<PaymentsEntity> uiCreator = new UICreator<>(PaymentsEntity.class);
        colsMap = uiCreator.initializePaymentsCols(colsMap);
        idPaymentCol = colsMap.get("id");
        sumPaymentCol = colsMap.get("sum");
        supplierPaymentCol = colsMap.get("supplier");
        accountPaymentCol = colsMap.get("account");
        paymentsTable.setItems(paymentsList);

    }


    public void initializeCustomersCols() {
        Map<String, TableColumn> colsMap = new HashMap<>();
        colsMap.put("id", idCustomersCol);
        colsMap.put("snp", snpCustomersCol);
        colsMap.put("ogrn", orgnCustomersCol);
        colsMap.put("inn", innCustomersCol);
        colsMap.put("firm", firmCustomersCol);
        colsMap.put("city", cityCustomersCol);
        colsMap.put("phone", phoneCustomersCol);
        colsMap.put("email", emailCustomersCol);
        colsMap.put("login", loginCustomersCol);
        UICreator<CustomersEntity> uiCreator = new UICreator<>(CustomersEntity.class);
        colsMap = uiCreator.initializeCustomersCols(colsMap);
        idCustomersCol = colsMap.get("id");
        snpCustomersCol = colsMap.get("snp");
        orgnCustomersCol = colsMap.get("ogrn");
        innCustomersCol = colsMap.get("inn");
        firmCustomersCol = colsMap.get("firm");
        cityCustomersCol = colsMap.get("city");
        phoneCustomersCol = colsMap.get("phone");
        emailCustomersCol = colsMap.get("email");
        loginCustomersCol = colsMap.get("login");
        customersTable.setItems(customersList);

    }

    public void initializeProjectsCols() {
        Map<String, TableColumn> colsMap = new HashMap<>();
        colsMap.put("id", idProjectCol);
        colsMap.put("title", titleProjectCol);
        colsMap.put("dev", devProjectCol);
        colsMap.put("material", materialProjectCol);
        colsMap.put("toy_type", toyTypeProjectCol);
        UICreator<ProjectsEntity> uiCreator = new UICreator<>(ProjectsEntity.class);
        colsMap = uiCreator.initializeProjectsCols(colsMap);
        idProjectCol = colsMap.get("id");
        titleProjectCol = colsMap.get("title");
        devProjectCol = colsMap.get("dev");
        materialProjectCol = colsMap.get("material");
        toyTypeProjectCol = colsMap.get("toy_type");
        projectsTable.setItems(projectsList);
    }

    public void initializeEquipmentTypesCols() {
        Map<String, TableColumn> colsMap = new HashMap<>();
        colsMap.put("id", idEqTypeCol);
        colsMap.put("title", eqTypeTitleCol);
        UICreator<EquipmentTypesEntity> uiCreator = new UICreator<>(EquipmentTypesEntity.class);
        colsMap = uiCreator.initializeEquipmentTypesCols(colsMap);
        idEqTypeCol = colsMap.get("id");
        eqTypeTitleCol = colsMap.get("title");
        equipmentTypesTable.setItems(equipmentTypesList);
    }


    public void initializeToyTypesCols() {
        Map<String, TableColumn> colsMap = new HashMap<>();
        colsMap.put("id", idToyTypeCol);
        colsMap.put("type", toyTypeCol);
        UICreator<ToyTypesEntity> uiCreator = new UICreator<>(ToyTypesEntity.class);
        colsMap = uiCreator.initializeToyTypesCols(colsMap);
        idToyTypeCol = colsMap.get("id");
        toyTypeCol = colsMap.get("type");
        toyTypesTable.setItems(toyTypesList);
    }

    public void initializeToysCols() {
        Map<String, TableColumn> colsMap = new HashMap<>();
        colsMap.put("id", idToyCol);
        colsMap.put("barcode", barcodeToyCol);
        colsMap.put("title", toyTitleCol);
        colsMap.put("age", ageCategorytoyCol);
        colsMap.put("weight", weightToyCol);
        colsMap.put("amount", detailsAmountToyCol);
        colsMap.put("toy_type", typeToyCol);
        colsMap.put("material", materialToyCol);
        UICreator<ToysEntity> uiCreator = new UICreator<>(ToysEntity.class);
        colsMap = uiCreator.initializeToysCols(colsMap);
        idToyCol = colsMap.get("id");
        barcodeToyCol = colsMap.get("barcode");
        toyTitleCol = colsMap.get("title");
        ageCategorytoyCol = colsMap.get("age");
        weightToyCol = colsMap.get("weight");
        detailsAmountToyCol = colsMap.get("amount");
        typeToyCol = colsMap.get("toy_type");
        materialToyCol = colsMap.get("material");
        toysTable.setItems(toysList);
    }


    public void initializeSelectionEmployees() {
        employeesTable.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            if (employeesTable.getSelectionModel().getSelectedItem() != null) {
                idEmployeeField.setText(newValue.idProperty().getValue().toString());
                snpEmployeeField.setText(newValue.snpProperty().getValue());
                cityEmployeeField.setText(newValue.getCity());
                addressEmplField.setText(newValue.getAddress());
                phoneEmployeeField.setText(newValue.getPhone());
                birthDateEmployeeField.setValue(newValue.getBirthDate());
                seatEmployeeField.setText(newValue.seatProperty().getValue().toString());
                departmentEmployeeField.setText(newValue.departmentProperty().getValue().toString());
                institutionField.setText(newValue.institutionProperty().getValue().toString());
                loginEmployeeField.setText(newValue.loginProperty().getValue());
            }
        });
    }

    public void initializeSelectionSuppliers() {
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

    public void initializeSelectionOrders() {
        ordersTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (ordersTable.getSelectionModel().getSelectedItem() != null) {
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

    public void initializeSelectionSeats() {
        seatsTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (seatsTable.getSelectionModel().getSelectedItem() != null) {
                idSeatsField.setText(newValue.idProperty().getValue().toString());
                seatField.setText(newValue.seatProperty().getValue());
                salaryField.setText(newValue.salaryProperty().getValue());
            }
        });
    }

    public void initializeSelectionEquipment() {
        equipmentTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (equipmentTable.getSelectionModel().getSelectedItem() != null) {
                idEqField.setText(newValue.idProperty().getValue().toString());
                eqTitleField.setText(newValue.titleProperty().getValue());
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate localDate = LocalDate.parse(newValue.getManufactureDate().toString(), formatter);
                dateManufactureField.setValue(localDate);
            }
        });
    }

    public void initializeSelectionProduce() {
        produceTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (produceTable.getSelectionModel().getSelectedItem() != null) {
                employeeProduceField.setText(newValue.employeeProperty().getValue().toString());
                toyProduceField.setText(newValue.toyProperty().getValue().toString());
                equipProduceField.setText(newValue.equipmentProperty().getValue().toString());
                orderNumberField.setText(newValue.currentOrderProperty().getValue().toString());
                materialAmountField.setText(newValue.materialCountProperty().getValue().toString());
            }
        });
    }

    public void initializeSelectionUsers() {
        usersTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (usersTable.getSelectionModel().getSelectedItem() != null) {
                loginField.setText(newValue.userLoginProperty().getValue());
                passwordField.setText(newValue.userPasswordProperty().getValue());
                roleField.setText(newValue.getUserRole().getRole());
            }
        });
    }

    public void initializeSelectionBanks() {
        bankTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (bankTable.getSelectionModel().getSelectedItem() != null) {
                idBankField.setText(newValue.idProperty().getValue().toString());
                bankField.setText(newValue.bankProperty().getValue());
            }
        });
    }

    public void initializeSelectionCustomers() {
        customersTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (customersTable.getSelectionModel().getSelectedItem() != null) {
                idCustomerField.setText(newValue.idProperty().getValue().toString());
                innCustomerField.setText(newValue.innProperty().getValue());
                snpCustomerField.setText(newValue.snpProperty().getValue());
                ogrnCustomerField.setText(newValue.ogrnProperty().getValue());
                cityCustomerField.setText(newValue.cityProperty().getValue());
                firmCustomerField.setText(newValue.firmtitleProperty().getValue());
                emailCustomerField.setText(newValue.emailProperty().getValue());
                phoneCustomerField.setText(newValue.phoneProperty().getValue());
                loginCustomerField.setText(newValue.loginProperty().getValue());
            }
        });
    }

    public void initializeSelectionAccounts() {
        accountsTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (accountsTable.getSelectionModel().getSelectedItem() != null) {
                idAccountField.setText(newValue.idProperty().getValue().toString());
                numberAccountField.setText(newValue.accountNumberProperty().getValue());
                bankAccountField.setText(newValue.bankProperty().getValue().toString());
            }
        });
    }

    public void initializeSelectionProjects() {
        projectsTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (projectsTable.getSelectionModel().getSelectedItem() != null) {
                idProjectField.setText(newValue.idProperty().getValue().toString());
                titleProjectField.setText(newValue.titleProperty().getValue());
                devProjectField.setText(newValue.currentStateProperty().getValue());
                materialProjectField.setText(newValue.materialProperty().getValue().toString());
                toyTypeProjectsField.setText(newValue.toyTypeProperty().getValue().toString());
            }
        });
    }

    public void initializeSelectionToys() {
        toysTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (toysTable.getSelectionModel().getSelectedItem() != null) {
                idToyField.setText(newValue.idProperty().getValue().toString());
                barcodeToyField.setText(newValue.barcodeProperty().getValue());
                titleToyField.setText(newValue.titleProperty().getValue());
                cathegoryToyField.setText(newValue.ageCategoryProperty().getValue());
                weightToyField.setText(newValue.netWeightProperty().getValue().toString());
                detailsAmountToyField.setText(newValue.detailsCountProperty().getValue().toString());
                toyTypeField.setText(newValue.toyType().getValue().toString());
                materialToyField.setText(newValue.material().getValue().toString());
            }
        });
    }

    public void initializeSelectionPayments() {
        paymentsTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (paymentsTable.getSelectionModel().getSelectedItem() != null) {
                idPaymentField.setText(newValue.idProperty().getValue().toString());
                ;
                sumPaymentField.setText(newValue.sumProperty().getValue());
                supplierPaymentField.setText(newValue.supplierProperty().getValue().toString());
                accNumberPaymentField.setText(newValue.accountProperty().getValue().toString());
            }
        });
    }

    public void initializeSelectionToyTypes() {
        toyTypesTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (toyTypesTable.getSelectionModel().getSelectedItem() != null) {
                idToyTypeField.setText(newValue.idProperty().getValue().toString());
                toyTypeTitleField.setText(newValue.toyTypeProperty().getValue());
            }
        });
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializeCols();
        initializeSelections();
    }

    public void initializeCols() {
        initializeSeatCols();
        initializeUserCols();
        initializeSupplierCols();
        initializeEmployeeCols();
        initializeOrderCols();
        initializeMaterialCols();
        initializeEquipmentCols();
        initializeProcurementCols();
        initializeToyProduceCols();
        initializeAccountsCols();
        initializeBanksCols();
        initializePaymentsCols();
        initializeCustomersCols();
        initializeProjectsCols();
        initializeEquipmentTypesCols();
        initializeToyTypesCols();
        initializeToysCols();

    }

    public void initializeSelections() {
        initializeSelectionEmployees();
        initializeSelectionSuppliers();
        initializeSelectionOrders();
        initializeSelectionSeats();
        initializeSelectionEquipment();
        initializeSelectionUsers();
        initializeSelectionBanks();
        initializeSelectionCustomers();
        initializeSelectionAccounts();
        initializeSelectionProjects();
        initializeSelectionToys();
        initializeSelectionPayments();
        initializeSelectionToyTypes();
        initializeSelectionProduce();
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
//        Session session = HibernateSessionFactory.getSessionFactory().openSession();
//        Transaction tx = session.beginTransaction();
//        Query query = session.createQuery("update SeatsEntity SET salary = :salaryParam, seat = :seatParam WHERE id = :idParam");
//        query.setParameter("salaryParam", salaryField.getText());
//        query.setParameter("seatParam", seatField.getText());
//        query.setParameter("idParam", idSeatsField.getText());
////        Query nativeQuery = session.createNativeQuery("UPDATE seats SET salary = " + salaryField.getText() + ", seat = \'" + seatField.getText() + "\' WHERE id = " + idSeatsField.getText());
////        nativeQuery.executeUpdate();
//        query.executeUpdate();
//        selectSeats(session);
//        Notifications.create().title("wfe").text("wef").position(Pos.CENTER).showConfirm();
//        tx.commit();
//        session.close();
    }

    public void getSeats(ActionEvent actionEvent) {
        HQLQueryGenerator<SeatsEntity> generator = new HQLQueryGenerator<>(SeatsEntity.class);
        generator.generateSelectQuery(seatsList);
    }

    public void addSeat(ActionEvent actionEvent) {

    }

    public void deleteSeat(ActionEvent actionEvent) {

    }

    public void changeUsers(ActionEvent actionEvent) {

    }

    public void updateUsers(ActionEvent actionEvent) {
        HQLQueryGenerator<UsersEntity> generator = new HQLQueryGenerator<>(UsersEntity.class);
        generator.generateSelectQuery(usersList);
    }

    public void addUser(ActionEvent actionEvent) {
//        Session session = HibernateSessionFactory.getSessionFactory().openSession();
//        Transaction tx = session.beginTransaction();
//        Query query = session.createNativeQuery("INSERT INTO users VALUES (\'" + loginField.getText() + "\',\'" + passwordField.getText() + "\',\'" + roleField.getText() + "\');");
//        query.executeUpdate();
//        tx.commit();
//        session.close();
    }

    public void deleteUser(ActionEvent actionEvent) {
        DialogManager.showInformationDialog("Пользователь был успешно удалён");
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
        HQLQueryGenerator<OrdersEntity> generator = new HQLQueryGenerator<>(OrdersEntity.class);
        generator.generateSelectQuery(ordersList);
    }

    public void changeOrder(ActionEvent actionEvent) {

    }

    public void addProcurement(ActionEvent actionEvent) {
    }

    public void changeProcurement(ActionEvent actionEvent) {
    }

    public void getProcurements(ActionEvent actionEvent) {
        HQLQueryGenerator<ProcurementsEntity> generator = new HQLQueryGenerator<>(ProcurementsEntity.class);
        generator.generateSelectQuery(procurementsList);
    }

    public void deleteProcurement(ActionEvent actionEvent) {
    }

    public void addSupplier(ActionEvent actionEvent) {
    }

    public void updateSuppliers(ActionEvent actionEvent) {
    }

    public void getSuppliers(ActionEvent actionEvent) {
        HQLQueryGenerator<SuppliersEntity> generator = new HQLQueryGenerator<>(SuppliersEntity.class);
        generator.generateSelectQuery(suppliersList);
    }

    public void deleteSupplier(ActionEvent actionEvent) {
    }

    public void addEquipment(ActionEvent actionEvent) {
    }

    public void changeEquipment(ActionEvent actionEvent) {
    }

    public void getEquipment(ActionEvent actionEvent) {
        HQLQueryGenerator<EquipmentEntity> generator = new HQLQueryGenerator<>(EquipmentEntity.class);
        generator.generateSelectQuery(equipmentList);
    }

    public void deleteEquip(ActionEvent actionEvent) {
    }

    public void addMaterial(ActionEvent actionEvent) {

    }

    public void changeMaterial(ActionEvent actionEvent) {

    }

    public void getMaterials(ActionEvent actionEvent) {
        HQLQueryGenerator<MaterialsEntity> generator = new HQLQueryGenerator<>(MaterialsEntity.class);
        generator.generateSelectQuery(materialsList);
    }

    public void deleteMaterial(ActionEvent actionEvent) {
        HQLQueryGenerator<MaterialsEntity> generator = new HQLQueryGenerator<>(MaterialsEntity.class);
        generator.generateDeleteQuery(materialsList, Integer.parseInt(idMaterialField.getText()));
    }

    public void addProduce(ActionEvent actionEvent) {

    }

    public void changeProduce(ActionEvent actionEvent) {

    }

    public void deleteProduce(ActionEvent actionEvent) {

    }

    public void getProduce(ActionEvent actionEvent) {
        HQLQueryGenerator<ToyProduceEntity> generator = new HQLQueryGenerator<>(ToyProduceEntity.class);
        generator.generateSelectQuery(produceList);
    }

    public void addEmployee(ActionEvent actionEvent) {
//        Session session = HibernateSessionFactory.getSessionFactory().openSession();
//        Transaction tx = session.beginTransaction();
//        Query query = session.createNativeQuery("INSERT INTO employees(snp,birthdate,city,address,phone,seat,department,institution, login) VALUES (\'" + snpEmployeeField.getText() + "\',\'" + birthDateEmployeeField.getValue().toString() + "\',\'" + cityEmployeeField.getText() + "\',\'" + addressEmplField.getText() + "\',\'" + phoneEmployeeField.getText() + "\',\'" + seatEmployeeField.getText() + "\',\'" + departmentEmployeeField.getText() + "\',\'" + institutionField.getText() + "\',\'" + loginField.getText() + "\');");
//        query.executeUpdate();
//        tx.commit();
//        session.close();
    }

    public void changeEmployee(ActionEvent actionEvent) {
//        Object[] parameters = {
//                Integer.parseInt(idEmployeeField.getText()),
//                snpEmployeeField.getText(),
//                birthDateEmployeeField.getValue(),
//                cityEmployeeField.getText(),
//                addressEmplField.getText(),
//                phoneEmployeeField.getText(),
//                Integer.parseInt(institutionField.getText()),
//                Integer.parseInt(departmentEmployeeField.getText()),
//                Integer.parseInt(seatEmployeeField.getText())
//        };
//        HQLQueryGenerator<EmployeesEntity> generator = new HQLQueryGenerator<>(EmployeesEntity.class);
//        generator.generateUpdateQuery(employeesList, EmployeesEntity.class.getDeclaredFields(), parameters);
        DialogManager.showInformationDialog("Информация была успешно изменена");
    }

    public void getEmployees(ActionEvent actionEvent) {
        HQLQueryGenerator<EmployeesEntity> generator = new HQLQueryGenerator<>(EmployeesEntity.class);
        generator.generateSelectQuery(employeesList);
    }

    public void deleteEmployee(ActionEvent actionEvent) {
        HQLQueryGenerator<EmployeesEntity> generator = new HQLQueryGenerator<>(EmployeesEntity.class);
        generator.generateDeleteQuery(employeesList, Integer.parseInt(idEmployeeField.getText()));
//        Session session = HibernateSessionFactory.getSessionFactory().openSession();
//        Transaction tx = session.beginTransaction();
//        Query query = session.createQuery("delete from EmployeesEntity where id = :id");
//        query.setParameter("id",Integer.parseInt(idEmployeeField.getText()));
//        query.executeUpdate();
//        tx.commit();
//        session.close();
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

    public void addAccount(ActionEvent actionEvent) {

    }

    public void changeAccount(ActionEvent actionEvent) {

    }

    public void getAccounts(ActionEvent actionEvent) {
        HQLQueryGenerator<AccountsEntity> generator = new HQLQueryGenerator<>(AccountsEntity.class);
        generator.generateSelectQuery(accountsList);
    }

    public void deleteAccount(ActionEvent actionEvent) {

    }

    public void addCustomer(ActionEvent actionEvent) {

    }

    public void changeCustomer(ActionEvent actionEvent) {

    }

    public void getCustomers(ActionEvent actionEvent) {
        HQLQueryGenerator<CustomersEntity> generator = new HQLQueryGenerator<>(CustomersEntity.class);
        generator.generateSelectQuery(customersList);
    }

    public void deleteCustomer(ActionEvent actionEvent) {

    }

    public void addBank(ActionEvent actionEvent) {
    }

    public void changeBank(ActionEvent actionEvent) {
    }

    public void getBanks(ActionEvent actionEvent) {
        HQLQueryGenerator<BanksEntity> generator = new HQLQueryGenerator<>(BanksEntity.class);
        generator.generateSelectQuery(banksList);
    }

    public void deleteBanks(ActionEvent actionEvent) {
    }


    public void addPayment(ActionEvent actionEvent) {

    }

    public void changePayments(ActionEvent actionEvent) {

    }

    public void updatePayments(ActionEvent actionEvent) {

    }

    public void deletePayment(ActionEvent actionEvent) {

    }

    public void addEqType(ActionEvent actionEvent) {

    }

    public void changeEqType(ActionEvent actionEvent) {

    }

    public void getEqType(ActionEvent actionEvent) {
        HQLQueryGenerator<EquipmentTypesEntity> generator = new HQLQueryGenerator<>(EquipmentTypesEntity.class);
        generator.generateSelectQuery(equipmentTypesList);
    }

    public void deleteEqType(ActionEvent actionEvent) {

    }

    public void addProject(ActionEvent actionEvent) {

    }

    public void changeProject(ActionEvent actionEvent) {

    }

    public void getProject(ActionEvent actionEvent) {
        HQLQueryGenerator<ProjectsEntity> generator = new HQLQueryGenerator<>(ProjectsEntity.class);
        generator.generateSelectQuery(projectsList);
    }

    public void deleteProject(ActionEvent actionEvent) {

    }

    public void addToyType(ActionEvent actionEvent) {

    }

    public void changeToyType(ActionEvent actionEvent) {

    }

    public void getToyType(ActionEvent actionEvent) {
        HQLQueryGenerator<ToyTypesEntity> generator = new HQLQueryGenerator<>(ToyTypesEntity.class);
        generator.generateSelectQuery(toyTypesList);
    }

    public void deleteToyType(ActionEvent actionEvent) {

    }

    public void addToy(ActionEvent actionEvent) {
    }

    public void changeToy(ActionEvent actionEvent) {
    }

    public void getToys(ActionEvent actionEvent) {
        HQLQueryGenerator<ToysEntity> generator = new HQLQueryGenerator<>(ToysEntity.class);
        generator.generateSelectQuery(toysList);
    }

    public void deleteToy(ActionEvent actionEvent) {
    }
}
