package db;

import javafx.beans.property.SimpleStringProperty;

import javax.persistence.*;

@Entity
@Table(name = "customers", schema = "public", catalog = "toy_factory")
public class CustomersEntity {
    private int id;
    private SimpleStringProperty snp = new SimpleStringProperty();
    private SimpleStringProperty ogrn= new SimpleStringProperty();
    private SimpleStringProperty inn= new SimpleStringProperty();
    private SimpleStringProperty firmtitle= new SimpleStringProperty();
    private SimpleStringProperty city= new SimpleStringProperty();
    private SimpleStringProperty phone= new SimpleStringProperty();
    private SimpleStringProperty email= new SimpleStringProperty();
    private SimpleStringProperty login= new SimpleStringProperty();

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "snp", nullable = false, length = 150)
    public String getSnp() {
        return snp.get();
    }

    public void setSnp(String snp) {
        this.snp.set(snp);
    }

    @Basic
    @Column(name = "ogrn", nullable = false, length = 150)
    public String getOgrn() {
        return ogrn.get();
    }

    public void setOgrn(String ogrn) {
        this.ogrn.set(ogrn);
    }

    @Basic
    @Column(name = "inn", nullable = false, length = 150)
    public String getInn() {
        return inn.get();
    }

    public void setInn(String inn) {
        this.inn.set(inn);
    }

    @Basic
    @Column(name = "firmtitle", nullable = false, length = 150)
    public String getFirmtitle() {
        return firmtitle.get();
    }

    public void setFirmtitle(String firmtitle) {
        this.firmtitle.set(firmtitle);
    }

    @Basic
    @Column(name = "city", nullable = false, length = 150)
    public String getCity() {
        return city.get();
    }

    public void setCity(String city) {
        this.city.set(city);
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
    @Column(name = "email", nullable = false, length = 150)
    public String getEmail() {
        return email.get();
    }

    public void setEmail(String email) {
        this.email.set(email);
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

        CustomersEntity that = (CustomersEntity) o;

        if (id != that.id) return false;
        if (snp != null ? !snp.equals(that.snp) : that.snp != null) return false;
        if (ogrn != null ? !ogrn.equals(that.ogrn) : that.ogrn != null) return false;
        if (inn != null ? !inn.equals(that.inn) : that.inn != null) return false;
        if (firmtitle != null ? !firmtitle.equals(that.firmtitle) : that.firmtitle != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (login != null ? !login.equals(that.login) : that.login != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (snp != null ? snp.hashCode() : 0);
        result = 31 * result + (ogrn != null ? ogrn.hashCode() : 0);
        result = 31 * result + (inn != null ? inn.hashCode() : 0);
        result = 31 * result + (firmtitle != null ? firmtitle.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (login != null ? login.hashCode() : 0);
        return result;
    }

    public SimpleStringProperty snpProperty() {
        return snp;
    }

    public SimpleStringProperty ogrnProperty() {
        return ogrn;
    }

    public SimpleStringProperty innProperty() {
        return inn;
    }

    public SimpleStringProperty firmtitleProperty() {
        return firmtitle;
    }

    public SimpleStringProperty cityProperty() {
        return city;
    }

    public SimpleStringProperty phoneProperty() {
        return phone;
    }

    public SimpleStringProperty emailProperty() {
        return email;
    }

    public SimpleStringProperty loginProperty() {
        return login;
    }
}
