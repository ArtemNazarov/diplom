package db;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class ToyProduceEntityPK implements Serializable {
    private int employee;
    private int toy;
    private int equipment;
    private int currentOrder;

    @Column(name = "employee", nullable = false)
    @Id
    public int getEmployee() {
        return employee;
    }

    public void setEmployee(int employee) {
        this.employee = employee;
    }

    @Column(name = "toy", nullable = false)
    @Id
    public int getToy() {
        return toy;
    }

    public void setToy(int toy) {
        this.toy = toy;
    }

    @Column(name = "equipment", nullable = false)
    @Id
    public int getEquipment() {
        return equipment;
    }

    public void setEquipment(int equipment) {
        this.equipment = equipment;
    }

    @Column(name = "current_order", nullable = false)
    @Id
    public int getCurrentOrder() {
        return currentOrder;
    }

    public void setCurrentOrder(int currentOrder) {
        this.currentOrder = currentOrder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ToyProduceEntityPK that = (ToyProduceEntityPK) o;

        if (employee != that.employee) return false;
        if (toy != that.toy) return false;
        if (equipment != that.equipment) return false;
        if (currentOrder != that.currentOrder) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = employee;
        result = 31 * result + toy;
        result = 31 * result + equipment;
        result = 31 * result + currentOrder;
        return result;
    }
}
