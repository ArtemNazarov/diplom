package db;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import javax.persistence.*;

@Entity
@Table(name = "materials", schema = "public", catalog = "toy_factory")
public class MaterialsEntity {
    private SimpleIntegerProperty id = new SimpleIntegerProperty();
    private SimpleStringProperty material = new SimpleStringProperty();

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    @Basic
    @Column(name = "material", nullable = false, length = 150)
    public String getMaterial() {
        return material.get();
    }

    public void setMaterial(String material) {
        this.material.set(material);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MaterialsEntity that = (MaterialsEntity) o;

        if (id != that.id) return false;
        if (material != null ? !material.equals(that.material) : that.material != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.get();
        result = 31 * result + (material != null ? material.hashCode() : 0);
        return result;
    }

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public SimpleStringProperty materialProperty() {
        return material;
    }
}
