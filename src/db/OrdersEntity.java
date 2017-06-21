package db;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "orders", schema = "public", catalog = "toy_factory")
public class OrdersEntity {
    private SimpleIntegerProperty id = new SimpleIntegerProperty();
    private SimpleStringProperty toyTitle = new SimpleStringProperty();
    private SimpleStringProperty orderCost = new SimpleStringProperty();
    private SimpleStringProperty currency = new SimpleStringProperty();
    private SimpleIntegerProperty productAmount = new SimpleIntegerProperty();
    private SimpleStringProperty orderState = new SimpleStringProperty();
    private Date executionDate;
    private SimpleIntegerProperty customer = new SimpleIntegerProperty();

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.setValue(id);
    }

    @Basic
    @Column(name = "toy_title", nullable = false, length = 150)
    public String getToyTitle() {
        return toyTitle.get();
    }

    public void setToyTitle(String toyTitle) {
        this.toyTitle.set(toyTitle);
    }

    @Basic
    @Column(name = "order_cost", nullable = false)
    public String getOrderCost() {
        return orderCost.get();
    }

    public void setOrderCost(String orderCost) {
        this.orderCost.set(orderCost);
    }

    @Basic
    @Column(name = "currency", nullable = false, length = 150)
    public String getCurrency() {
        return currency.get();
    }

    public void setCurrency(String currency) {
        this.currency.set(currency);
    }

    @Basic
    @Column(name = "product_amount", nullable = false)
    public int getProductAmount() {
        return productAmount.get();
    }

    public void setProductAmount(int productAmount) {
        this.productAmount.set(productAmount);
    }

    @Basic
    @Column(name = "order_state", nullable = false, length = 150)
    public String getOrderState() {
        return orderState.get();
    }

    public void setOrderState(String orderState) {
        this.orderState.set(orderState);
    }

    @Column(name = "execution_date", nullable = true)
    public Date getExecutionDate() {
        return executionDate;
    }

    public void setExecutionDate(Date executionDate) {
        this.executionDate = executionDate;
    }


    @Basic
    @Column(name = "customer", nullable = false)
    public int getCustomer() {
        return customer.get();
    }

    public void setCustomer(int customer) {
        this.customer.set(customer);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrdersEntity that = (OrdersEntity) o;

        if (id != that.id) return false;
        if (productAmount != that.productAmount) return false;
        if (toyTitle != null ? !toyTitle.equals(that.toyTitle) : that.toyTitle != null) return false;
        if (orderCost != null ? !orderCost.equals(that.orderCost) : that.orderCost != null) return false;
        if (currency != null ? !currency.equals(that.currency) : that.currency != null) return false;
        if (orderState != null ? !orderState.equals(that.orderState) : that.orderState != null) return false;
        if (executionDate != null ? !executionDate.equals(that.executionDate) : that.executionDate != null)
            return false;

        return true;
    }

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public SimpleStringProperty toyTitleProperty() {
        return toyTitle;
    }

    public SimpleStringProperty orderCostProperty() {
        return orderCost;
    }

    public SimpleStringProperty currencyProperty() {
        return currency;
    }

    public SimpleIntegerProperty productAmountProperty() {
        return productAmount;
    }

    public SimpleStringProperty orderStateProperty() {
        return orderState;
    }

    @Override
    public int hashCode() {
        int result = id.get();
        result = 31 * result + (toyTitle != null ? toyTitle.hashCode() : 0);
        result = 31 * result + (orderCost != null ? orderCost.hashCode() : 0);
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        result = 31 * result + productAmount.get();
        result = 31 * result + (orderState != null ? orderState.hashCode() : 0);
        result = 31 * result + (executionDate != null ? executionDate.hashCode() : 0);
        return result;
    }


    public SimpleIntegerProperty customerProperty() {
        return customer;
    }

}
