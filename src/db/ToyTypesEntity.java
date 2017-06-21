package db;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import javax.persistence.*;

@Entity
@Table(name = "toy_types", schema = "public", catalog = "toy_factory")
public class ToyTypesEntity {
    private SimpleIntegerProperty id = new SimpleIntegerProperty();
    private SimpleStringProperty toyType = new SimpleStringProperty();

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public SimpleStringProperty toyTypeProperty() {
        return toyType;
    }

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    @Basic
    @Column(name = "toy_type", nullable = false, length = 150)
    public String getToyType() {
        return toyType.get();
    }

    public void setToyType(String toyType) {
        this.toyType.set(toyType);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ToyTypesEntity that = (ToyTypesEntity) o;

        if (id != that.id) return false;
        if (toyType != null ? !toyType.equals(that.toyType) : that.toyType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.get();
        result = 31 * result + (toyType != null ? toyType.hashCode() : 0);
        return result;
    }
}
