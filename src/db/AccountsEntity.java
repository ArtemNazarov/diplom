package db;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import javax.persistence.*;

/**
 * Created by Артем on 19.06.2017.
 */
@Entity
@Table(name = "accounts", schema = "public", catalog = "toy_factory")
public class AccountsEntity {
    private SimpleIntegerProperty id = new SimpleIntegerProperty();
    private SimpleStringProperty accountNumber = new SimpleStringProperty();
    private SimpleIntegerProperty bank = new SimpleIntegerProperty();

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public SimpleStringProperty accountNumberProperty() {
        return accountNumber;
    }

    public SimpleIntegerProperty bankProperty() {
        return bank;
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
    @Column(name = "account_number")
    public String getAccountNumber() {
        return accountNumber.get();
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber.set(accountNumber);
    }

    @Basic
    @Column(name = "bank")
    public int getBank() {
        return bank.get();
    }

    public void setBank(int bank) {
        this.bank.set(bank);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccountsEntity that = (AccountsEntity) o;

        if (id != that.id) return false;
        if (accountNumber != null ? !accountNumber.equals(that.accountNumber) : that.accountNumber != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.get();
        result = 31 * result + (accountNumber != null ? accountNumber.hashCode() : 0);
        return result;
    }
}
