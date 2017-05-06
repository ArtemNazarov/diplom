package db;

import javax.persistence.*;

@Entity
@Table(name = "equipment_types", schema = "public", catalog = "toy_factory")
public class EquipmentTypesEntity {
    private int id;
    private String equipmentType;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "equipment_type", nullable = false, length = 150)
    public String getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(String equipmentType) {
        this.equipmentType = equipmentType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EquipmentTypesEntity that = (EquipmentTypesEntity) o;

        if (id != that.id) return false;
        if (equipmentType != null ? !equipmentType.equals(that.equipmentType) : that.equipmentType != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (equipmentType != null ? equipmentType.hashCode() : 0);
        return result;
    }
}
