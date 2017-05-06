package db;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Entity
@Table(name = "employees", schema = "public", catalog = "toy_factory")
public class EmployeesEntity {
    private SimpleIntegerProperty id= new SimpleIntegerProperty();
    private SimpleStringProperty snp = new SimpleStringProperty();
    private LocalDate birthdate;
    private SimpleStringProperty city= new SimpleStringProperty();
    private SimpleStringProperty address= new SimpleStringProperty();
    private SimpleStringProperty phone= new SimpleStringProperty();
    private SimpleIntegerProperty seat= new SimpleIntegerProperty();
    private SimpleIntegerProperty department= new SimpleIntegerProperty();
    private SimpleIntegerProperty institution= new SimpleIntegerProperty();
    private SimpleStringProperty login= new SimpleStringProperty();

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);;
    }

    @Basic
    @Column(name = "snp", nullable = false, length = 150)
    public String getSnp() {
        return snp.get();
    }

    public void setSnp(String snp) {
        this.snp.set(snp);
    }

    @Convert (converter = EmployeesEntity.DateConverter.class)
    @Column(name = "birthdate", nullable = false)
    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    @Basic
    @Column(name = "city", nullable = true, length = 150)
    public String getCity() {
        return city.get();
    }

    public void setCity(String city) {
        this.city.set(city);
    }

    @Basic
    @Column(name = "address", nullable = true, length = 150)
    public String getAddress() {
        return address.get();
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    @Basic
    @Column(name = "phone", nullable = false, length = 150)
    public String getPhone() {
        return phone.get();
    }

    public void setPhone(String phone) {
        this.phone.set(phone);
    }

    @Basic
    @Column(name = "seat", nullable = false)
    public int getSeat() {
        return seat.get();
    }

    public void setSeat(int seat) {
        this.seat.set(seat);
    }

    @Basic
    @Column(name = "department", nullable = false)
    public int getDepartment() {
        return department.get();
    }

    public void setDepartment(int department) {
        this.department.set(department);
    }

    @Basic
    @Column(name = "institution", nullable = false)
    public int getInstitution() {
        return institution.get();
    }

    public void setInstitution(int institution) {
        this.institution.set(institution);
    }

    @Basic
    @Column(name = "login", nullable = false, length = 150)
    public String getLogin() {
        return login.get();
    }

    public void setLogin(String login) {
        this.login.set(login);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeesEntity that = (EmployeesEntity) o;

        if (id != that.id) return false;
        if (seat != that.seat) return false;
        if (department != that.department) return false;
        if (institution != that.institution) return false;
        if (snp != null ? !snp.equals(that.snp) : that.snp != null) return false;
        if (birthdate != null ? !birthdate.equals(that.birthdate) : that.birthdate != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (login != null ? !login.equals(that.login) : that.login != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.get();
        result = 31 * result + (snp != null ? snp.hashCode() : 0);
        result = 31 * result + (birthdate != null ? birthdate.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + seat.get();
        result = 31 * result + department.get();
        result = 31 * result + institution.get();
        result = 31 * result + (login != null ? login.hashCode() : 0);
        return result;
    }

    @Converter
    public static class DateConverter implements AttributeConverter<LocalDate, Date>{
        @Override
        public Date convertToDatabaseColumn(LocalDate locDate) {
            return (locDate == null ? null : Date.valueOf(locDate));
        }

        @Override
        public LocalDate convertToEntityAttribute(Date sqlDate) {
            return (sqlDate == null ? null : sqlDate.toLocalDate());
        }
    }

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public SimpleStringProperty snpProperty() {
        return snp;
    }

    public SimpleStringProperty cityProperty() {
        return city;
    }

    public SimpleStringProperty addressProperty() {
        return address;
    }

    public SimpleStringProperty phoneProperty() {
        return phone;
    }

    public SimpleIntegerProperty seatProperty() {
        return seat;
    }

    public SimpleIntegerProperty departmentProperty() {
        return department;
    }

    public SimpleIntegerProperty institutionProperty() {
        return institution;
    }

    public SimpleStringProperty loginProperty() {
        return login;
    }
}
