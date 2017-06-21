package db;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import javax.persistence.*;

/**
 * Created by Артем on 19.06.2017.
 */
@Entity
@Table(name = "projects", schema = "public", catalog = "toy_factory")
public class ProjectsEntity {
    private SimpleIntegerProperty id = new SimpleIntegerProperty();
    private SimpleStringProperty title = new SimpleStringProperty();
    private SimpleStringProperty currentState = new SimpleStringProperty();
    private SimpleIntegerProperty material = new SimpleIntegerProperty();
    private SimpleIntegerProperty toyType = new SimpleIntegerProperty();

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public SimpleStringProperty titleProperty() {
        return title;
    }

    public SimpleStringProperty currentStateProperty() {
        return currentState;
    }

    public SimpleIntegerProperty materialProperty() {
        return material;
    }

    public SimpleIntegerProperty toyTypeProperty() {
        return toyType;
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title.get();
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    @Basic
    @Column(name = "current_state")
    public String getCurrentState() {
        return currentState.get();
    }

    public void setCurrentState(String currentState) {
        this.currentState.set(currentState);
    }

    @Basic
    @Column(name = "material")
    public int getMaterial() {
        return material.get();
    }

    public void setMaterial(int material) {
        this.material.set(material);
    }

    @Basic
    @Column(name = "toy_type")
    public int getToyType() {
        return toyType.get();
    }

    public void setToyType(int toyType) {
        this.toyType.set(toyType);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProjectsEntity that = (ProjectsEntity) o;

        if (id != that.id) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (currentState != null ? !currentState.equals(that.currentState) : that.currentState != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.get();
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (currentState != null ? currentState.hashCode() : 0);
        return result;
    }
}
