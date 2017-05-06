package db;

import javax.persistence.*;

@Entity
@Table(name = "toy_types", schema = "public", catalog = "toy_factory")
public class ToyTypesEntity {
    private int id;
    private String toyType;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "toy_type", nullable = false, length = 150)
    public String getToyType() {
        return toyType;
    }

    public void setToyType(String toyType) {
        this.toyType = toyType;
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
        int result = id;
        result = 31 * result + (toyType != null ? toyType.hashCode() : 0);
        return result;
    }
}
