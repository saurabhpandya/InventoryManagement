package com.inventorymanagement.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.inventorymanagement.model.base.Auditable;

import javax.persistence.*;

@Entity(name = "product_variant_mapping")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductVariantMapping extends Auditable<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "p_id")
    private Integer productId;
    private String size;
    private String color;
    private int quantity;
    private double price;
    private boolean active;
    private boolean deleted;
    private boolean blocked;

    public ProductVariantMapping() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ProductVariantMapping{");
        sb.append("id=").append(id);
        sb.append(", productId=").append(productId);
        sb.append(", size='").append(size).append('\'');
        sb.append(", color='").append(color).append('\'');
        sb.append(", quantity=").append(quantity);
        sb.append(", price=").append(price);
        sb.append(", active=").append(active);
        sb.append(", deleted=").append(deleted);
        sb.append(", blocked=").append(blocked);
        sb.append('}');
        return sb.toString();
    }
}
