package db;

import javax.persistence.*;

@Entity
@Table(name = "packages", schema = "public", catalog = "toy_factory")
public class PackagesEntity {
    private int id;
    private int length;
    private int width;
    private int height;
    private int weight;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "length", nullable = false)
    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Basic
    @Column(name = "width", nullable = false)
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Basic
    @Column(name = "height", nullable = false)
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Basic
    @Column(name = "weight", nullable = false)
    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PackagesEntity that = (PackagesEntity) o;

        if (id != that.id) return false;
        if (length != that.length) return false;
        if (width != that.width) return false;
        if (height != that.height) return false;
        if (weight != that.weight) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + length;
        result = 31 * result + width;
        result = 31 * result + height;
        result = 31 * result + weight;
        return result;
    }
}
