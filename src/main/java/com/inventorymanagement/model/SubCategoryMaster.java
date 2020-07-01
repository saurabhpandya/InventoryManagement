package com.inventorymanagement.model;

import com.inventorymanagement.model.base.Auditable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "sub_category_master")
public class SubCategoryMaster extends Auditable<String> {
    @Id
    private int id;
    private String name;
    @Column(name = "cat_id")
    private int catId;
    @Column(name = "sub_cat_id")
    private int subCatId;
    private boolean active;
    private boolean deleted;
    private boolean blocked;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

    public int getSubCatId() {
        return subCatId;
    }

    public void setSubCatId(int subCatId) {
        this.subCatId = subCatId;
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
        final StringBuilder sb = new StringBuilder("SubCategoryMaster{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", catId=").append(catId);
        sb.append(", subCatId=").append(subCatId);
        sb.append(", active=").append(active);
        sb.append(", deleted=").append(deleted);
        sb.append(", blocked=").append(blocked);
        sb.append('}');
        return sb.toString();
    }
}
