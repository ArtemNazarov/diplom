package db;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Артем on 19.06.2017.
 */
@Entity
@Table(name = "toys", schema = "public", catalog = "toy_factory")
public class ToysEntity {
    private SimpleIntegerProperty id= new SimpleIntegerProperty();
    private SimpleStringProperty barcode= new SimpleStringProperty();
    private SimpleStringProperty title= new SimpleStringProperty();
    private Date produceDate;
    private SimpleStringProperty additionalInfo= new SimpleStringProperty();
    private SimpleStringProperty ageCategory= new SimpleStringProperty();
    private SimpleStringProperty restrictions= new SimpleStringProperty();
    private SimpleIntegerProperty netWeight= new SimpleIntegerProperty();
    private SimpleIntegerProperty length= new SimpleIntegerProperty();
    private SimpleIntegerProperty width= new SimpleIntegerProperty();
    private SimpleIntegerProperty height= new SimpleIntegerProperty();
    private SimpleIntegerProperty grossWeight= new SimpleIntegerProperty();
    private SimpleIntegerProperty detailsCount= new SimpleIntegerProperty();
    private SimpleIntegerProperty toyType = new SimpleIntegerProperty();
    private SimpleIntegerProperty material = new SimpleIntegerProperty();

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public SimpleStringProperty barcodeProperty() {
        return barcode;
    }

    public SimpleStringProperty titleProperty() {
        return title;
    }

    public SimpleStringProperty additionalInfoProperty() {
        return additionalInfo;
    }

    public SimpleStringProperty ageCategoryProperty() {
        return ageCategory;
    }

    public SimpleStringProperty restrictionsProperty() {
        return restrictions;
    }

    public SimpleIntegerProperty netWeightProperty() {
        return netWeight;
    }

    public SimpleIntegerProperty lengthProperty() {
        return length;
    }

    public SimpleIntegerProperty widthProperty() {
        return width;
    }

    public SimpleIntegerProperty heightProperty() {
        return height;
    }

    public SimpleIntegerProperty grossWeightProperty() {
        return grossWeight;
    }

    public SimpleIntegerProperty detailsCountProperty() {
        return detailsCount;
    }

    public SimpleIntegerProperty toyType() {return toyType;}
    public SimpleIntegerProperty material() {return material;}

    @Id
    @Column(name = "id")
    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    @Basic
    @Column(name = "barcode")
    public String getBarcode() {
        return barcode.get();
    }

    public void setBarcode(String barcode) {
        this.barcode.set(barcode);
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
    @Column(name = "produce_date")
    public Date getProduceDate() {
        return produceDate;
    }

    public void setProduceDate(Date produceDate) {
        this.produceDate = produceDate;
    }

    @Basic
    @Column(name = "additional_info")
    public String getAdditionalInfo() {
        return additionalInfo.get();
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo.set(additionalInfo);
    }

    @Basic
    @Column(name = "age_category")
    public String getAgeCategory() {
        return ageCategory.get();
    }

    public void setAgeCategory(String ageCategory) {
        this.ageCategory.set(ageCategory);
    }

    @Basic
    @Column(name = "restrictions")
    public String getRestrictions() {
        return restrictions.get();
    }

    public void setRestrictions(String restrictions) {
        this.restrictions.set(restrictions);
    }

    @Basic
    @Column(name = "net_weight")
    public int getNetWeight() {
        return netWeight.get();
    }

    public void setNetWeight(int netWeight) {
        this.netWeight.set(netWeight);
    }

    @Basic
    @Column(name = "length")
    public int getLength() {
        return length.get();
    }

    public void setLength(int length) {
        this.length.set(length);
    }

    @Basic
    @Column(name = "width")
    public int getWidth() {
        return width.get();
    }

    public void setWidth(int width) {
        this.width.set(width);
    }

    @Basic
    @Column(name = "height")
    public int getHeight() {
        return height.get();
    }

    public void setHeight(int height) {
        this.height.set(height);
    }

    @Basic
    @Column(name = "gross_weight")
    public int getGrossWeight() {
        return grossWeight.get();
    }

    public void setGrossWeight(int grossWeight) {
        this.grossWeight.set(grossWeight);
    }

    @Basic
    @Column(name = "details_count")
    public Integer getDetailsCount() {
        return detailsCount.get();
    }

    public void setDetailsCount(Integer detailsCount) {
        this.detailsCount.set(detailsCount);
    }

    @Basic
    @Column(name = "toy_type")
    public Integer getToyType() {
        return toyType.get();
    }

    public void setToyType(Integer toyType) {
        this.toyType.set(toyType);
    }

    @Basic
    @Column(name = "material")
    public Integer getMaterial() {
        return material.get();
    }

    public void setMaterial(Integer toyType) {
        this.toyType.set(toyType);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ToysEntity that = (ToysEntity) o;

        if (id != that.id) return false;
        if (netWeight != that.netWeight) return false;
        if (length != that.length) return false;
        if (width != that.width) return false;
        if (height != that.height) return false;
        if (grossWeight != that.grossWeight) return false;
        if (barcode != null ? !barcode.equals(that.barcode) : that.barcode != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (produceDate != null ? !produceDate.equals(that.produceDate) : that.produceDate != null) return false;
        if (additionalInfo != null ? !additionalInfo.equals(that.additionalInfo) : that.additionalInfo != null)
            return false;
        if (ageCategory != null ? !ageCategory.equals(that.ageCategory) : that.ageCategory != null) return false;
        if (restrictions != null ? !restrictions.equals(that.restrictions) : that.restrictions != null) return false;
        if (detailsCount != null ? !detailsCount.equals(that.detailsCount) : that.detailsCount != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.get();
        result = 31 * result + (barcode != null ? barcode.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (produceDate != null ? produceDate.hashCode() : 0);
        result = 31 * result + (additionalInfo != null ? additionalInfo.hashCode() : 0);
        result = 31 * result + (ageCategory != null ? ageCategory.hashCode() : 0);
        result = 31 * result + (restrictions != null ? restrictions.hashCode() : 0);
        result = 31 * result + netWeight.get();
        result = 31 * result + length.get();
        result = 31 * result + width.get();
        result = 31 * result + height.get();
        result = 31 * result + grossWeight.get();
        result = 31 * result + (detailsCount != null ? detailsCount.hashCode() : 0);
        return result;
    }
}
