package db;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class PackageFabricateEntityPK implements Serializable {
    private int employee;
    private int equipment;
    private int currentPackage;

    @Column(name = "employee", nullable = false)
    @Id
    public int getEmployee() {
        return employee;
    }

    public void setEmployee(int employee) {
        this.employee = employee;
    }

    @Column(name = "equipment", nullable = false)
    @Id
    public int getEquipment() {
        return equipment;
    }

    public void setEquipment(int equipment) {
        this.equipment = equipment;
    }

    @Column(name = "current_package", nullable = false)
    @Id
    public int getCurrentPackage() {
        return currentPackage;
    }

    public void setCurrentPackage(int currentPackage) {
        this.currentPackage = currentPackage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PackageFabricateEntityPK that = (PackageFabricateEntityPK) o;

        if (employee != that.employee) return false;
        if (equipment != that.equipment) return false;
        if (currentPackage != that.currentPackage) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = employee;
        result = 31 * result + equipment;
        result = 31 * result + currentPackage;
        return result;
    }
}
