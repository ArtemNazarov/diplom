package db;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Артем on 19.06.2017.
 */
@Entity
@Table(name = "payments", schema = "public", catalog = "toy_factory")
public class PaymentsEntity {
    private SimpleIntegerProperty id = new SimpleIntegerProperty();
    private SimpleStringProperty sum = new SimpleStringProperty();
    private SimpleIntegerProperty supplier= new SimpleIntegerProperty();
    private SimpleIntegerProperty account= new SimpleIntegerProperty();

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public SimpleStringProperty sumProperty() {
        return sum;
    }

    public SimpleIntegerProperty supplierProperty() {
        return supplier;
    }

    public SimpleIntegerProperty accountProperty() {
        return account;
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    @Basic
    @Column(name = "sum")
    public String getSum() {
        return sum.get();
    }

    public void setSum(String sum) {
        this.sum.set(sum);
    }

    @Basic
    @Column(name = "supplier")
    public int getSupplier() {
        return supplier.get();
    }

    public void setSupplier(int supplier) {
        this.supplier.set(supplier);
    }

    @Basic
    @Column(name = "account")
    public int getAccount() {
        return account.get();
    }

    public void setAccount(int account) {
        this.account.set(account);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PaymentsEntity that = (PaymentsEntity) o;

        if (id != that.id) return false;
        if (sum != null ? !sum.equals(that.sum) : that.sum != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.get();
        result = 31 * result + (sum != null ? sum.hashCode() : 0);
        return result;
    }
}
