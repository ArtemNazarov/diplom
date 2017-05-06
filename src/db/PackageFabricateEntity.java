package db;

import javax.persistence.*;

@Entity
@Table(name = "package_fabricate", schema = "public", catalog = "toy_factory")
@IdClass(PackageFabricateEntityPK.class)
public class PackageFabricateEntity {
    private int employee;
    private int equipment;
    private int currentPackage;
    private int materialAmount;

    @Id
    @Column(name = "employee", nullable = false)
    public int getEmployee() {
        return employee;
    }

    public void setEmployee(int employee) {
        this.employee = employee;
    }

    @Id
    @Column(name = "equipment", nullable = false)
    public int getEquipment() {
        return equipment;
    }

    public void setEquipment(int equipment) {
        this.equipment = equipment;
    }

    @Id
    @Column(name = "current_package", nullable = false)
    public int getCurrentPackage() {
        return currentPackage;
    }

    public void setCurrentPackage(int currentPackage) {
        this.currentPackage = currentPackage;
    }

    @Basic
    @Column(name = "material_amount", nullable = false)
    public int getMaterialAmount() {
        return materialAmount;
    }

    public void setMaterialAmount(int materialAmount) {
        this.materialAmount = materialAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PackageFabricateEntity that = (PackageFabricateEntity) o;

        if (employee != that.employee) return false;
        if (equipment != that.equipment) return false;
        if (currentPackage != that.currentPackage) return false;
        if (materialAmount != that.materialAmount) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = employee;
        result = 31 * result + equipment;
        result = 31 * result + currentPackage;
        result = 31 * result + materialAmount;
        return result;
    }
}
