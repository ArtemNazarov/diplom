package db;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import javax.persistence.*;

/**
 * Created by Артем on 19.06.2017.
 */
@Entity
@Table(name = "banks", schema = "public", catalog = "toy_factory")
public class BanksEntity {
    private SimpleIntegerProperty id = new SimpleIntegerProperty();
    private SimpleStringProperty bank = new SimpleStringProperty();

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public SimpleStringProperty bankProperty() {
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
    @Column(name = "bank")
    public String getBank() {
        return bank.get();
    }

    public void setBank(String bank) {
        this.bank.set(bank);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BanksEntity that = (BanksEntity) o;

        if (id != that.id) return false;
        if (bank != null ? !bank.equals(that.bank) : that.bank != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.get();
        result = 31 * result + (bank != null ? bank.hashCode() : 0);
        return result;
    }
}
