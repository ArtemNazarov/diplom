package db;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "equipment", schema = "public", catalog = "toy_factory")
public class EquipmentEntity {
    private SimpleIntegerProperty id = new SimpleIntegerProperty();
    private SimpleStringProperty title = new SimpleStringProperty();
    private Date manufactureDate;
    private SimpleStringProperty eqFunction = new SimpleStringProperty();
    private SimpleIntegerProperty eqType = new SimpleIntegerProperty();

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    @Basic
    @Column(name = "title", nullable = true, length = 150)
    public String getTitle() {
        return title.get();
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    @Basic
    @Column(name = "manufacture_date", nullable = true)
    public Date getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(Date manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    @Basic
    @Column(name = "eq_function", nullable = true, length = 150)
    public String getEqFunction() {
        return eqFunction.get();
    }

    public void setEqFunction(String eqFunction) {
        this.eqFunction.set(eqFunction);;
    }

    @Basic
    @Column(name = "eq_type", nullable = false)
    public int getEqType(){
        return this.eqType.get();
    }

    public void setEqType(int eq_type){
        this.eqType.set(eq_type);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EquipmentEntity that = (EquipmentEntity) o;

        if (id != that.id) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (manufactureDate != null ? !manufactureDate.equals(that.manufactureDate) : that.manufactureDate != null)
            return false;
        if (eqFunction != null ? !eqFunction.equals(that.eqFunction) : that.eqFunction != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.get();
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (manufactureDate != null ? manufactureDate.hashCode() : 0);
        result = 31 * result + (eqFunction != null ? eqFunction.hashCode() : 0);
        return result;
    }

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public SimpleStringProperty titleProperty() {
        return title;
    }

    public SimpleStringProperty eqFunctionProperty() {
        return eqFunction;
    }

    public SimpleIntegerProperty eqTypeProperty() {
        return eqType;
    }
}
