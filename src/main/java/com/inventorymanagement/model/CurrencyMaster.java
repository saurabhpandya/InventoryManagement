package com.inventorymanagement.model;

import com.inventorymanagement.model.base.Auditable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "currency_master")
public class CurrencyMaster extends Auditable<String> {
    @Id
    private int id;
    private String name;
    private String shortName;
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

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
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
        final StringBuilder sb = new StringBuilder("CurrencyMaster{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", shortName='").append(shortName).append('\'');
        sb.append(", active=").append(active);
        sb.append(", deleted=").append(deleted);
        sb.append(", blocked=").append(blocked);
        sb.append('}');
        return sb.toString();
    }
}
