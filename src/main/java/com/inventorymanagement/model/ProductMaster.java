package com.inventorymanagement.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.inventorymanagement.model.base.Auditable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "product_master")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductMaster extends Auditable<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String description;
    @Column(name = "sub_cat_id")
    private Integer subCatId;
    @Column(name = "supplier_id")
    private Integer supplierId;
    private double price;
    @Column(name = "currency_id")
    private Integer currencyId;
    private int quantity;
    private boolean active;
    private boolean deleted;
    private boolean blocked;
    //    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "p_id", referencedColumnName = "id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Transient
    private List<ProductVariantMapping> productVariantMapping = new ArrayList<>();

    public ProductMaster() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getSubCatId() {
        return subCatId;
    }

    public void setSubCatId(Integer subCatId) {
        this.subCatId = subCatId;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Integer currencyId) {
        this.currencyId = currencyId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public List<ProductVariantMapping> getProductVariantMapping() {
        return productVariantMapping;
    }

    public void setProductVariantMapping(List<ProductVariantMapping> productVariantMapping) {
        this.productVariantMapping = productVariantMapping;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ProductMaster{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", subCatId=").append(subCatId);
        sb.append(", supplierId=").append(supplierId);
        sb.append(", price=").append(price);
        sb.append(", currencyId=").append(currencyId);
        sb.append(", quantity=").append(quantity);
        sb.append(", active=").append(active);
        sb.append(", deleted=").append(deleted);
        sb.append(", blocked=").append(blocked);
        sb.append(", productVariantMapping=").append(productVariantMapping);
        sb.append('}');
        return sb.toString();
    }
}
