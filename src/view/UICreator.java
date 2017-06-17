package view;

import db.EmployeesEntity;
import db.OrdersEntity;
import db.SuppliersEntity;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Артем on 17.06.2017.
 */
public class UICreator<T> {

    private final Class<T> classType;

    public UICreator(Class<T> type) {
        this.classType = type;
    }

    public Class<T> getMyType() {
        return this.classType;
    }

    public TableView<T> createTable(ObservableList<T> items) {
        TableView<T> tableView = new TableView<>();
        tableView.setItems(items);
        return tableView;
    }

    public TableView<T> changeTable(ObservableList<T> items, TableView<T> tableView) {
        tableView.setItems(items);

        return tableView;
    }


    public Map<String, TableColumn> initializeSupplierCols(Map<String, TableColumn> colsMap) {
        TableColumn<SuppliersEntity, Integer> idSupplierCol = colsMap.get("id");
        TableColumn<SuppliersEntity, String> ogrnSupplierCol = colsMap.get("ogrn");
        TableColumn<SuppliersEntity, String> innSupplierCol = colsMap.get("inn");
        TableColumn<SuppliersEntity, String> firmTitleFieldSupplierCol = colsMap.get("firmTitle");
        TableColumn<SuppliersEntity, Integer> contractValidityCol = colsMap.get("contractValidity");
        TableColumn<SuppliersEntity, String> contractDateCol = colsMap.get("contractDate");

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
        return colsMap;
    }

    public Map<String, TableColumn> initializeEmployeeCols(Map<String, TableColumn> colsMap) {
        TableColumn<EmployeesEntity, Integer> idEmployee = colsMap.get("id");
        TableColumn<EmployeesEntity, String> snpEmployee = colsMap.get("snp");
        TableColumn<EmployeesEntity, String> birthDateEmployee = colsMap.get("birthDate");
        TableColumn<EmployeesEntity, String> cityEmployee = colsMap.get("city");
        TableColumn<EmployeesEntity, String> addressEmployee = colsMap.get("address");
        TableColumn<EmployeesEntity, String> phoneEmployee = colsMap.get("phone");
        TableColumn<EmployeesEntity, Integer> seatEmployeeCol = colsMap.get("seat");
        TableColumn<EmployeesEntity, Integer> departmentEmployeeCol = colsMap.get("department");
        TableColumn<EmployeesEntity, String> loginEmployeeCol = colsMap.get("login");
        TableColumn<EmployeesEntity, Integer> institutionEmployeeCol = colsMap.get("institution");
        idEmployee.setCellValueFactory(celldata -> celldata.getValue().idProperty().asObject());
        snpEmployee.setCellValueFactory(celldata -> celldata.getValue().snpProperty());
        birthDateEmployee.setCellValueFactory(param -> {
            SimpleStringProperty property = new SimpleStringProperty();
            property.setValue(param.getValue().getBirthDate().toString());
            return property;
        });
        cityEmployee.setCellValueFactory(celldata -> celldata.getValue().cityProperty());
        addressEmployee.setCellValueFactory(celldata -> celldata.getValue().addressProperty());
        phoneEmployee.setCellValueFactory(celldata -> celldata.getValue().phoneProperty());
        seatEmployeeCol.setCellValueFactory(celldata -> celldata.getValue().seatProperty().asObject());
        departmentEmployeeCol.setCellValueFactory(celldata -> celldata.getValue().departmentProperty().asObject());
        institutionEmployeeCol.setCellValueFactory(celldata -> celldata.getValue().institutionProperty().asObject());
        loginEmployeeCol.setCellValueFactory(celldata -> celldata.getValue().loginProperty());
        return colsMap;
    }
//
//    public void initializeOrderCols() {
//        idOrderCol.setCellValueFactory(celldata -> celldata.getValue().idProperty().asObject());
//        toyTitleOrderCol.setCellValueFactory(celldata -> celldata.getValue().toyTitleProperty());
//        toyCostOrderCol.setCellValueFactory(celldata -> celldata.getValue().orderCostProperty());
//        currencyOrderCol.setCellValueFactory(celldata -> celldata.getValue().currencyProperty());
//        amountOrderCol.setCellValueFactory(celldata -> celldata.getValue().productAmountProperty().asObject());
//        orderStateCol.setCellValueFactory(celldata -> celldata.getValue().orderStateProperty());
//        dateExecutionOrderCol.setCellValueFactory(param -> {
//            SimpleStringProperty property = new SimpleStringProperty();
//            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//            property.setValue(dateFormat.format(param.getValue().getExecutionDate()));
//            return property;
//        });
//        ordersTable.setItems(ordersList);
//    }
//
//    public void initializeSeatCols() {
//        idSeatCol.setCellValueFactory(celldata -> celldata.getValue().idProperty().asObject());
//        salaryCol.setCellValueFactory(celldata -> celldata.getValue().salaryProperty());
//        seatCol.setCellValueFactory(celldata -> celldata.getValue().seatProperty());
//        seatsTable.setItems(seatsList);
//    }
//
//    public void initializeUserCols() {
//        loginCol.setCellValueFactory(celldata -> celldata.getValue().userLoginProperty());
//        passwCol.setCellValueFactory(celldata -> celldata.getValue().userPasswordProperty());
//        roleCol.setCellValueFactory(param -> {
//            roleProperty.setValue(param.getValue().getUserRole().getRole());
//            return roleProperty;
//        });
//        usersTable.setItems(usersList);
//    }
//
//    public void initializeMaterialCols() {
//        idMaterialCol.setCellValueFactory(celldata -> celldata.getValue().idProperty().asObject());
//        materialCol.setCellValueFactory(celldata -> celldata.getValue().materialProperty());
//        materialsTable.setItems(materialsList);
//    }
//
//    public void initializeEquipmentCols() {
//        idEquipCol.setCellValueFactory(celldata -> celldata.getValue().idProperty().asObject());
//        eqTitleCol.setCellValueFactory(celldata -> celldata.getValue().titleProperty());
//        manufactureDateCol.setCellValueFactory(param -> {
//            SimpleStringProperty property = new SimpleStringProperty();
//            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//            property.setValue(dateFormat.format(param.getValue().getManufactureDate()));
//            return property;
//        });
//        purposeCol.setCellValueFactory(celldata -> celldata.getValue().eqFunctionProperty());
//        eqTypeCol.setCellValueFactory(celldata -> celldata.getValue().eqTypeProperty().asObject());
//        equipmentTable.setItems(equipmentList);
//    }
//
//    public void initializeProcurementCols() {
//        idProcurementCol.setCellValueFactory(celldata -> celldata.getValue().idProperty().asObject());
//        dateExecProcurCol.setCellValueFactory(param -> {
//            SimpleStringProperty property = new SimpleStringProperty();
//            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//            property.setValue(dateFormat.format(param.getValue().getProcurementDate()));
//            return property;
//        });
//        amountMaterialCol.setCellValueFactory(celldata -> celldata.getValue().materialCountProperty().asObject());
//        supplierProcurementCol.setCellValueFactory(celldata -> celldata.getValue().supplierProperty().asObject());
//        materialProcurementCol.setCellValueFactory(celldata -> celldata.getValue().materialProperty().asObject());
//        procurementsTable.setItems(procurementsList);
//    }
//
//    public void initializeToyProduceCols() {
//        toyProduceCol.setCellValueFactory(celldata -> celldata.getValue().toyProperty().asObject());
//        eqProduceCol.setCellValueFactory(celldata -> celldata.getValue().equipmentProperty().asObject());
//        orderProduceCol.setCellValueFactory(celldata -> celldata.getValue().currentOrderProperty().asObject());
//        amountMaterialProduceCol.setCellValueFactory(celldata -> celldata.getValue().materialCountProperty().asObject());
//        produceTable.setItems(produceList);
//    }
//
//
//    public void initializeSelectionEmployees() {
//        employeesTable.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
//            if (employeesTable.getSelectionModel().getSelectedItem() != null) {
//                idEmployeeField.setText(newValue.idProperty().getValue().toString());
//                snpEmployeeField.setText(newValue.snpProperty().getValue());
//                cityEmployeeField.setText(newValue.getCity());
//                addressEmplField.setText(newValue.getAddress());
//                phoneEmployeeField.setText(newValue.getPhone());
//                birthDateEmployeeField.setValue(newValue.getBirthDate());
//                seatEmployeeField.setText(newValue.seatProperty().getValue().toString());
//                departmentEmployeeField.setText(newValue.departmentProperty().getValue().toString());
//                institutionField.setText(newValue.institutionProperty().getValue().toString());
//                loginEmployeeField.setText(newValue.loginProperty().getValue());
//            }
//        });
//    }
//
//    public void initializeSelectionSuppliers() {
//        suppliersTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
//            if (suppliersTable.getSelectionModel().getSelectedItem() != null) {
//                idSupplierField.setText(newValue.idProperty().getValue().toString());
//                ogrnSupplierField.setText(newValue.ogrnProperty().getValue());
//                innSupplierField.setText(newValue.innProperty().getValue());
//                firmTitleSupplierField.setText(newValue.firmtitleProperty().getValue());
//                contractValidityField.setText(newValue.contractValidityProperty().getValue().toString());
//                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//                LocalDate localDate = LocalDate.parse(newValue.getContractSignDate().toString(), formatter);
//                contractDateField.setValue(localDate);
//            }
//        });
//    }
//
//    public void initializeSelectionOrders() {
//        ordersTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
//            if (ordersTable.getSelectionModel().getSelectedItem() != null) {
//                idOrderField.setText(newValue.idProperty().getValue().toString());
//                toyTitleOrderField.setText(newValue.toyTitleProperty().getValue());
//                toyCostOrderField.setText(newValue.orderCostProperty().getValue());
//                currencyOrderField.setText(newValue.currencyProperty().getValue());
//                amountOrderField.setText(newValue.productAmountProperty().getValue().toString());
//                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//                LocalDate localDate = LocalDate.parse(newValue.getExecutionDate().toString(), formatter);
//                orderStateField.setText(newValue.orderStateProperty().getValue());
//                dateExecField.setValue(localDate);
//            }
//        });
//    }
//
//    public void initializeSelectionSeats() {
//        seatsTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
//            if (seatsTable.getSelectionModel().getSelectedItem() != null) {
//                idSeatsField.setText(newValue.idProperty().getValue().toString());
//                seatField.setText(newValue.seatProperty().getValue());
//                salaryField.setText(newValue.salaryProperty().getValue());
//            }
//        });
//    }
//
//    public void initializeSelectionEquipment() {
//        equipmentTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
//            if (equipmentTable.getSelectionModel().getSelectedItem() != null) {
//                idEqField.setText(newValue.idProperty().getValue().toString());
//                eqTitleField.setText(newValue.titleProperty().getValue());
//                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//                LocalDate localDate = LocalDate.parse(newValue.getManufactureDate().toString(), formatter);
//                dateManufactureField.setValue(localDate);
//            }
//        });
//    }
//
//    public void initializeSelectionUsers() {
//        usersTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
//            if (usersTable.getSelectionModel().getSelectedItem() != null) {
//                loginField.setText(newValue.userLoginProperty().getValue());
//                passwordField.setText(newValue.userPasswordProperty().getValue());
//                roleField.setText(newValue.getUserRole().getRole());
//            }
//        });
//    }
}
