package db;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "suppliers", schema = "public", catalog = "toy_factory")
public class SuppliersEntity {
    private SimpleIntegerProperty id = new SimpleIntegerProperty();
    private SimpleStringProperty ogrn = new SimpleStringProperty();
    private SimpleStringProperty inn = new SimpleStringProperty();
    private SimpleStringProperty firmtitle = new SimpleStringProperty();
    private SimpleStringProperty snpDirector = new SimpleStringProperty();
    private SimpleIntegerProperty contractValidity = new SimpleIntegerProperty();
    private Date contractSignDate;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
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
    @Column(name = "snp_director", nullable = false, length = 150)
    public String getSnpDirector() {
        return snpDirector.get();
    }

    public void setSnpDirector(String snpDirector) {
        this.snpDirector.set(snpDirector);
    }

    @Basic
    @Column(name = "contract_validity", nullable = false)
    public int getContractValidity() {
        return contractValidity.get();
    }

    public void setContractValidity(int contractValidity) {
        this.contractValidity.set(contractValidity);
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "contract_sign_date", nullable = false)
    public Date getContractSignDate() {
        return contractSignDate;
    }

    public void setContractSignDate(Date contractSignDate) {
        this.contractSignDate = contractSignDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SuppliersEntity that = (SuppliersEntity) o;

        if (id != that.id) return false;
        if (contractValidity != that.contractValidity) return false;
        if (ogrn != null ? !ogrn.equals(that.ogrn) : that.ogrn != null) return false;
        if (inn != null ? !inn.equals(that.inn) : that.inn != null) return false;
        if (firmtitle != null ? !firmtitle.equals(that.firmtitle) : that.firmtitle != null) return false;
        if (snpDirector != null ? !snpDirector.equals(that.snpDirector) : that.snpDirector != null) return false;
        if (contractSignDate != null ? !contractSignDate.equals(that.contractSignDate) : that.contractSignDate != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.get();
        result = 31 * result + (ogrn != null ? ogrn.hashCode() : 0);
        result = 31 * result + (inn != null ? inn.hashCode() : 0);
        result = 31 * result + (firmtitle != null ? firmtitle.hashCode() : 0);
        result = 31 * result + (snpDirector != null ? snpDirector.hashCode() : 0);
        result = 31 * result + contractValidity.get();
        result = 31 * result + (contractSignDate != null ? contractSignDate.hashCode() : 0);
        return result;
    }

    public SimpleIntegerProperty idProperty() {
        return id;
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

    public SimpleStringProperty snpDirectorProperty() {
        return snpDirector;
    }

    public SimpleIntegerProperty contractValidityProperty() {
        return contractValidity;
    }
}
