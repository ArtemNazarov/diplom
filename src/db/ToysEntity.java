package db;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "toys", schema = "public", catalog = "toy_factory")
public class ToysEntity {
    private int id;
    private String barcode;
    private String title;
    private Date produceDate;
    private String additionalInfo;
    private String ageCategory;
    private String restrictions;
    private int netWeight;
    private int length;
    private int width;
    private int height;
    private int grossWeight;
    private Integer detailsCount;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "barcode", nullable = false, length = 150)
    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    @Basic
    @Column(name = "title", nullable = false, length = 150)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "produce_date", nullable = true)
    public Date getProduceDate() {
        return produceDate;
    }

    public void setProduceDate(Date produceDate) {
        this.produceDate = produceDate;
    }

    @Basic
    @Column(name = "additional_info", nullable = true, length = 650)
    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    @Basic
    @Column(name = "age_category", nullable = false, length = 150)
    public String getAgeCategory() {
        return ageCategory;
    }

    public void setAgeCategory(String ageCategory) {
        this.ageCategory = ageCategory;
    }

    @Basic
    @Column(name = "restrictions", nullable = true, length = 150)
    public String getRestrictions() {
        return restrictions;
    }

    public void setRestrictions(String restrictions) {
        this.restrictions = restrictions;
    }

    @Basic
    @Column(name = "net_weight", nullable = false)
    public int getNetWeight() {
        return netWeight;
    }

    public void setNetWeight(int netWeight) {
        this.netWeight = netWeight;
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
    @Column(name = "gross_weight", nullable = false)
    public int getGrossWeight() {
        return grossWeight;
    }

    public void setGrossWeight(int grossWeight) {
        this.grossWeight = grossWeight;
    }

    @Basic
    @Column(name = "details_count", nullable = true)
    public Integer getDetailsCount() {
        return detailsCount;
    }

    public void setDetailsCount(Integer detailsCount) {
        this.detailsCount = detailsCount;
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
        int result = id;
        result = 31 * result + (barcode != null ? barcode.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (produceDate != null ? produceDate.hashCode() : 0);
        result = 31 * result + (additionalInfo != null ? additionalInfo.hashCode() : 0);
        result = 31 * result + (ageCategory != null ? ageCategory.hashCode() : 0);
        result = 31 * result + (restrictions != null ? restrictions.hashCode() : 0);
        result = 31 * result + netWeight;
        result = 31 * result + length;
        result = 31 * result + width;
        result = 31 * result + height;
        result = 31 * result + grossWeight;
        result = 31 * result + (detailsCount != null ? detailsCount.hashCode() : 0);
        return result;
    }
}
