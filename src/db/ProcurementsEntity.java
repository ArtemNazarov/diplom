package db;

import javafx.beans.property.SimpleIntegerProperty;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "procurements", schema = "public", catalog = "toy_factory")
public class ProcurementsEntity {
    private SimpleIntegerProperty id = new SimpleIntegerProperty();
    private Date procurementDate;
    private SimpleIntegerProperty materialCount = new SimpleIntegerProperty();
    private SimpleIntegerProperty supplier = new SimpleIntegerProperty();
    private SimpleIntegerProperty material = new SimpleIntegerProperty();

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "procurement_date", nullable = false)
    public Date getProcurementDate() {
        return procurementDate;
    }

    public void setProcurementDate(java.util.Date procurementDate) {
        this.procurementDate = procurementDate;
    }

    @Basic
    @Column(name = "material_count", nullable = false)
    public int getMaterialCount() {
        return materialCount.get();
    }

    public void setMaterialCount(int materialCount) {
        this.materialCount.set(materialCount);
    }

    @Basic
    @Column(name = "supplier", nullable = false)
    public int getSupplier() {
        return supplier.get();
    }

    public void setSupplier(int supplier) {
        this.supplier.set(supplier);
    }

    @Basic
    @Column(name = "material", nullable = false)
    public int getMaterial() {
        return material.get();
    }

    public void setMaterial(int material) {
        this.material.set(material);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProcurementsEntity that = (ProcurementsEntity) o;

        if (id != that.id) return false;
        if (materialCount != that.materialCount) return false;
        if (supplier != that.supplier) return false;
        if (material != that.material) return false;
        if (procurementDate != null ? !procurementDate.equals(that.procurementDate) : that.procurementDate != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.get();
        result = 31 * result + (procurementDate != null ? procurementDate.hashCode() : 0);
        result = 31 * result + materialCount.get();
        result = 31 * result + supplier.get();
        result = 31 * result + material.get();
        return result;
    }

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public SimpleIntegerProperty materialCountProperty() {
        return materialCount;
    }

    public SimpleIntegerProperty supplierProperty() {
        return supplier;
    }

    public SimpleIntegerProperty materialProperty() {
        return material;
    }
}
