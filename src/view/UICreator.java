package view;

import db.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

    public Map<String, TableColumn> initializeOrderCols(Map<String, TableColumn> colsMap) {
        TableColumn<OrdersEntity, Integer> idOrderCol = colsMap.get("id");
        TableColumn<OrdersEntity, String> toyTitleOrderCol = colsMap.get("toyTitle");
        TableColumn<OrdersEntity, String> toyCostOrderCol = colsMap.get("toyCost");
        TableColumn<OrdersEntity, String> currencyOrderCol = colsMap.get("currency");
        TableColumn<OrdersEntity, Integer> amountOrderCol = colsMap.get("amount");
        TableColumn<OrdersEntity, String> orderStateCol = colsMap.get("state");
        TableColumn<OrdersEntity, String> dateExecutionOrderCol = colsMap.get("execdate");

        idOrderCol.setCellValueFactory(celldata -> celldata.getValue().idProperty().asObject());
        toyTitleOrderCol.setCellValueFactory(celldata -> celldata.getValue().toyTitleProperty());
        toyCostOrderCol.setCellValueFactory(celldata -> celldata.getValue().orderCostProperty());
        currencyOrderCol.setCellValueFactory(celldata -> celldata.getValue().currencyProperty());
        amountOrderCol.setCellValueFactory(celldata -> celldata.getValue().productAmountProperty().asObject());
        orderStateCol.setCellValueFactory(celldata -> celldata.getValue().orderStateProperty());
        dateExecutionOrderCol.setCellValueFactory(param -> {
            SimpleStringProperty property = new SimpleStringProperty();
            property.setValue(param.getValue().getExecutionDate().toString());
            return property;
        });
        return colsMap;
    }

    public Map<String, TableColumn> initializeSeatCols(Map<String, TableColumn> colsMap) {
        TableColumn<SeatsEntity, Integer> idSeatCol = colsMap.get("id");
        TableColumn<SeatsEntity, String> salaryCol = colsMap.get("salary");
        TableColumn<SeatsEntity, String> seatCol = colsMap.get("seat");

        idSeatCol.setCellValueFactory(celldata -> celldata.getValue().idProperty().asObject());
        salaryCol.setCellValueFactory(celldata -> celldata.getValue().salaryProperty());
        seatCol.setCellValueFactory(celldata -> celldata.getValue().seatProperty());
        return colsMap;
    }

    public Map<String, TableColumn> initializeUserCols(Map<String, TableColumn> colsMap) {
        SimpleStringProperty roleProperty = new SimpleStringProperty();
        TableColumn<UsersEntity, String> loginCol = colsMap.get("login");
        TableColumn<UsersEntity, String> passwCol = colsMap.get("password");
        TableColumn<UsersEntity, String> roleCol = colsMap.get("role");

        loginCol.setCellValueFactory(celldata -> celldata.getValue().userLoginProperty());
        passwCol.setCellValueFactory(celldata -> celldata.getValue().userPasswordProperty());
        roleCol.setCellValueFactory(param -> {
            roleProperty.setValue(param.getValue().getUserRole().getRole());
            return roleProperty;
        });
        return colsMap;
    }

    public Map<String, TableColumn> initializeMaterialCols(Map<String, TableColumn> colsMap) {
        TableColumn<MaterialsEntity, Integer> idMaterialCol = colsMap.get("id");
        TableColumn<MaterialsEntity, String> materialCol = colsMap.get("material");
        idMaterialCol.setCellValueFactory(celldata -> celldata.getValue().idProperty().asObject());
        materialCol.setCellValueFactory(celldata -> celldata.getValue().materialProperty());
        return colsMap;
    }

    public Map<String, TableColumn> initializeEquipmentCols(Map<String, TableColumn> colsMap) {
        TableColumn<EquipmentEntity, Integer> idEquipCol = colsMap.get("id");
        TableColumn<EquipmentEntity, String> eqTitleCol = colsMap.get("title");
        TableColumn<EquipmentEntity, String> manufactureDateCol = colsMap.get("manufacture");
        TableColumn<EquipmentEntity, String> purposeCol = colsMap.get("purpose");
        TableColumn<EquipmentEntity, Integer> eqTypeCol = colsMap.get("type");

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
        return colsMap;
    }

    public Map<String, TableColumn> initializeProcurementCols(Map<String, TableColumn> colsMap) {
        TableColumn<ProcurementsEntity, Integer> idProcurementCol = colsMap.get("id");
        TableColumn<ProcurementsEntity, String> dateExecProcurCol = colsMap.get("date");
        TableColumn<ProcurementsEntity, Integer> amountMaterialCol = colsMap.get("amount");
        TableColumn<ProcurementsEntity, Integer> supplierProcurementCol = colsMap.get("supplier");
        TableColumn<ProcurementsEntity, Integer> materialProcurementCol = colsMap.get("material");
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
        return colsMap;

    }

    public Map<String, TableColumn> initializeToyProduceCols(Map<String, TableColumn> colsMap) {
        TableColumn<ToyProduceEntity, Integer> toyProduceCol = colsMap.get("toy");
        TableColumn<ToyProduceEntity, Integer> eqProduceCol = colsMap.get("eq");
        TableColumn<ToyProduceEntity, Integer> orderProduceCol = colsMap.get("order");
        TableColumn<ToyProduceEntity, Integer> amountMaterialProduceCol = colsMap.get("amount");

        toyProduceCol.setCellValueFactory(celldata -> celldata.getValue().toyProperty().asObject());
        eqProduceCol.setCellValueFactory(celldata -> celldata.getValue().equipmentProperty().asObject());
        orderProduceCol.setCellValueFactory(celldata -> celldata.getValue().currentOrderProperty().asObject());
        amountMaterialProduceCol.setCellValueFactory(celldata -> celldata.getValue().materialCountProperty().asObject());
        return colsMap;
    }

    public Map<String, TableColumn> initializeAccountsCols(Map<String, TableColumn> colsMap) {
        TableColumn<AccountsEntity, Integer> idAccountCol = colsMap.get("id");
        TableColumn<AccountsEntity, String> numberAccountsCol = colsMap.get("number");
        TableColumn<AccountsEntity, Integer> bankAccountsCol = colsMap.get("bank");

        idAccountCol.setCellValueFactory(celldata -> celldata.getValue().idProperty().asObject());
        numberAccountsCol.setCellValueFactory(celldata -> celldata.getValue().accountNumberProperty());
        bankAccountsCol.setCellValueFactory(celldata -> celldata.getValue().bankProperty().asObject());
        return colsMap;
    }

    public Map<String, TableColumn> initializeBankCols(Map<String, TableColumn> colsMap) {
        TableColumn<BanksEntity, Integer> idBankCol = colsMap.get("id");
        TableColumn<BanksEntity, String> bankCol = colsMap.get("bank");

        idBankCol.setCellValueFactory(celldata -> celldata.getValue().idProperty().asObject());
        bankCol.setCellValueFactory(celldata -> celldata.getValue().bankProperty());
        return colsMap;
    }

    public Map<String, TableColumn> initializePaymentsCols(Map<String, TableColumn> colsMap) {

        TableColumn<PaymentsEntity, Integer> idPaymentCol = colsMap.get("id");
        TableColumn<PaymentsEntity, String> sumPaymentCol = colsMap.get("sum");
        TableColumn<PaymentsEntity, Integer> supplierPaymentCol = colsMap.get("supplier");
        TableColumn<PaymentsEntity, Integer> accountPaymentCol = colsMap.get("account");

        idPaymentCol.setCellValueFactory(celldata -> celldata.getValue().idProperty().asObject());
        sumPaymentCol.setCellValueFactory(celldata -> celldata.getValue().sumProperty());
        supplierPaymentCol.setCellValueFactory(celldata -> celldata.getValue().supplierProperty().asObject());
        accountPaymentCol.setCellValueFactory(celldata -> celldata.getValue().accountProperty().asObject());
        return colsMap;
    }

    public Map<String, TableColumn> initializeCustomersCols(Map<String, TableColumn> colsMap) {
        TableColumn<CustomersEntity, Integer> idCustomersCol= colsMap.get("id");
        TableColumn<CustomersEntity, String> snpCustomersCol= colsMap.get("snp");
        TableColumn<CustomersEntity, String> orgnCustomersCol= colsMap.get("ogrn");
        TableColumn<CustomersEntity, String> innCustomersCol= colsMap.get("inn");
        TableColumn<CustomersEntity, String> firmCustomersCol= colsMap.get("firm");
        TableColumn<CustomersEntity, String> cityCustomersCol= colsMap.get("city");
        TableColumn<CustomersEntity, String> phoneCustomersCol= colsMap.get("phone");
        TableColumn<CustomersEntity, String> emailCustomersCol= colsMap.get("email");
        TableColumn<CustomersEntity, String> loginCustomersCol= colsMap.get("login");

        idCustomersCol.setCellValueFactory(celldata -> celldata.getValue().idProperty().asObject());
        snpCustomersCol.setCellValueFactory(celldata -> celldata.getValue().snpProperty());
        orgnCustomersCol.setCellValueFactory(celldata -> celldata.getValue().ogrnProperty());
        innCustomersCol.setCellValueFactory(celldata -> celldata.getValue().innProperty());
        firmCustomersCol.setCellValueFactory(celldata -> celldata.getValue().firmtitleProperty());
        cityCustomersCol.setCellValueFactory(celldata -> celldata.getValue().cityProperty());
        phoneCustomersCol.setCellValueFactory(celldata -> celldata.getValue().phoneProperty());
        emailCustomersCol.setCellValueFactory(celldata -> celldata.getValue().emailProperty());
        loginCustomersCol.setCellValueFactory(celldata -> celldata.getValue().loginProperty());
        return colsMap;
    }

    public Map<String, TableColumn> initializeProjectsCols(Map<String, TableColumn> colsMap) {
        TableColumn<ProjectsEntity, Integer> idProjectCol = colsMap.get("id");
        TableColumn<ProjectsEntity, String> titleProjectCol = colsMap.get("title");
        TableColumn<ProjectsEntity, String> devProjectCol = colsMap.get("dev");
        TableColumn<ProjectsEntity, Integer> materialProjectCol = colsMap.get("material");
        TableColumn<ProjectsEntity, Integer> toyTypeProjectCol = colsMap.get("toy_type");

        idProjectCol.setCellValueFactory(celldata -> celldata.getValue().idProperty().asObject());
        titleProjectCol.setCellValueFactory(celldata -> celldata.getValue().titleProperty());
        devProjectCol.setCellValueFactory(celldata -> celldata.getValue().currentStateProperty());
        materialProjectCol.setCellValueFactory(celldata -> celldata.getValue().materialProperty().asObject());
        toyTypeProjectCol.setCellValueFactory(celldata -> celldata.getValue().toyTypeProperty().asObject());

        return colsMap;
    }

    public Map<String, TableColumn> initializeToysCols(Map<String, TableColumn> colsMap) {

        TableColumn<ToysEntity, Integer> idToyCol = colsMap.get("id");
        TableColumn<ToysEntity, String> barcodeToyCol = colsMap.get("barcode");
        TableColumn<ToysEntity, String> toyTitleCol = colsMap.get("title");
        TableColumn<ToysEntity, String> ageCategorytoyCol = colsMap.get("age");
        TableColumn<ToysEntity, Integer> weightToyCol = colsMap.get("weight");
        TableColumn<ToysEntity, Integer> detailsAmountToyCol = colsMap.get("amount");
        TableColumn<ToysEntity, Integer> typeToyCol = colsMap.get("toy_type");
        TableColumn<ToysEntity, Integer> materialToyCol = colsMap.get("material");

        idToyCol.setCellValueFactory(celldata -> celldata.getValue().idProperty().asObject());
        barcodeToyCol.setCellValueFactory(celldata -> celldata.getValue().barcodeProperty());
        toyTitleCol.setCellValueFactory(celldata -> celldata.getValue().titleProperty());
        ageCategorytoyCol.setCellValueFactory(celldata -> celldata.getValue().ageCategoryProperty());
        weightToyCol.setCellValueFactory(celldata -> celldata.getValue().netWeightProperty().asObject());
        detailsAmountToyCol.setCellValueFactory(celldata -> celldata.getValue().detailsCountProperty().asObject());
        typeToyCol.setCellValueFactory(celldata -> celldata.getValue().toyType().asObject());
        materialToyCol.setCellValueFactory(celldata -> celldata.getValue().material().asObject());

        return colsMap;
    }

    public Map<String, TableColumn> initializeToyTypesCols(Map<String, TableColumn> colsMap) {
        TableColumn<ToyTypesEntity, Integer> idToyTypeCol = colsMap.get("id");
        TableColumn<ToyTypesEntity, String> toyTypeCol = colsMap.get("type");
        idToyTypeCol.setCellValueFactory(celldata -> celldata.getValue().idProperty().asObject());
        toyTypeCol.setCellValueFactory(celldata -> celldata.getValue().toyTypeProperty());
        return colsMap;
    }

    public Map<String, TableColumn> initializeEquipmentTypesCols(Map<String, TableColumn> colsMap) {
        TableColumn<EquipmentTypesEntity, Integer> idEqTypeCol = colsMap.get("id");
        TableColumn<EquipmentTypesEntity, String> eqTypeTitleCol = colsMap.get("title");
        idEqTypeCol.setCellValueFactory(celldata -> celldata.getValue().idProperty().asObject());
        eqTypeTitleCol.setCellValueFactory(celldata -> celldata.getValue().equipmentTypeProperty());
        return colsMap;
    }


}
