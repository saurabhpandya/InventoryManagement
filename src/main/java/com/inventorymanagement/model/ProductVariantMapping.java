package com.inventorymanagement.model;

import com.inventorymanagement.model.base.Auditable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "product_varient_mapping")
public class ProductVariantMapping extends Auditable<String> {
    @Id
    private int id;
    @Column(name = "product_id")
    private int productId;
    private double size;
    private String color;
    private int quantity;
    private double price;
    private boolean active;
    private boolean deleted;
    private boolean blocked;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
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
        sb.append(", size=").append(size);
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
