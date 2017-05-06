package db;

import javafx.beans.property.SimpleIntegerProperty;

import javax.persistence.*;

@Entity
@Table(name = "toy_produce", schema = "public", catalog = "toy_factory")
@IdClass(ToyProduceEntityPK.class)
public class ToyProduceEntity {
    private SimpleIntegerProperty employee = new SimpleIntegerProperty();
    private SimpleIntegerProperty toy= new SimpleIntegerProperty();
    private SimpleIntegerProperty equipment= new SimpleIntegerProperty();
    private SimpleIntegerProperty currentOrder= new SimpleIntegerProperty();
    private SimpleIntegerProperty materialCount= new SimpleIntegerProperty();

    @Id
    @Column(name = "employee", nullable = false)
    public int getEmployee() {
        return employee.get();
    }

    public void setEmployee(int employee) {
        this.employee.set(employee);
    }

    @Id
    @Column(name = "toy", nullable = false)
    public int getToy() {
        return toy.get();
    }

    public void setToy(int toy) {
        this.toy.set(toy);
    }

    @Id
    @Column(name = "equipment", nullable = false)
    public int getEquipment() {
        return equipment.get();
    }

    public void setEquipment(int equipment) {
        this.equipment.set(equipment);;
    }

    @Id
    @Column(name = "current_order", nullable = false)
    public int getCurrentOrder() {
        return currentOrder.get();
    }

    public void setCurrentOrder(int currentOrder) {
        this.currentOrder.set(currentOrder);
    }

    @Basic
    @Column(name = "material_count", nullable = false)
    public int getMaterialCount() {
        return materialCount.get();
    }

    public void setMaterialCount(int materialCount) {
        this.materialCount.set(materialCount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ToyProduceEntity that = (ToyProduceEntity) o;

        if (employee != that.employee) return false;
        if (toy != that.toy) return false;
        if (equipment != that.equipment) return false;
        if (currentOrder != that.currentOrder) return false;
        if (materialCount != that.materialCount) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = employee.get();
        result = 31 * result + toy.get();
        result = 31 * result + equipment.get();
        result = 31 * result + currentOrder.get();
        result = 31 * result + materialCount.get();
        return result;
    }

    public SimpleIntegerProperty employeeProperty() {
        return employee;
    }

    public SimpleIntegerProperty toyProperty() {
        return toy;
    }

    public SimpleIntegerProperty equipmentProperty() {
        return equipment;
    }

    public SimpleIntegerProperty currentOrderProperty() {
        return currentOrder;
    }

    public SimpleIntegerProperty materialCountProperty() {
        return materialCount;
    }
}
