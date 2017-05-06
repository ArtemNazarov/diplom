package db;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "seats", schema = "public", catalog = "toy_factory")
public class SeatsEntity {
    private SimpleIntegerProperty id = new SimpleIntegerProperty();
    private SimpleStringProperty seat = new SimpleStringProperty();
    private SimpleStringProperty salary = new SimpleStringProperty();

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    @Basic
    @Column(name = "seat", nullable = false, length = 150)
    public String getSeat() {
        return seat.get();
    }

    public void setSeat(String seat) {
        this.seat.set(seat);
    }

    @Basic
    @Column(name = "salary", nullable = false)
    public String getSalary() {
        return salary.get();
    }

    public void setSalary(String salary) {
        this.salary.set(salary);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SeatsEntity that = (SeatsEntity) o;

        if (id != that.id) return false;
        if (seat != null ? !seat.equals(that.seat) : that.seat != null) return false;
        if (salary != null ? !salary.equals(that.salary) : that.salary != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.get();
        result = 31 * result + (seat != null ? seat.hashCode() : 0);
        result = 31 * result + (salary != null ? salary.hashCode() : 0);
        return result;
    }

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public SimpleStringProperty seatProperty() {
        return seat;
    }

    public SimpleStringProperty salaryProperty() {
        return salary;
    }
}
