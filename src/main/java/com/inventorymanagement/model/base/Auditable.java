package com.inventorymanagement.model.base;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class Auditable<U> {

    @CreatedBy
    @Column(name = "created_by", nullable = false, updatable = false)
    private U createdBY;

    @CreatedDate
    @Column(name = "created_date", nullable = false, updatable = false)
    private Date createdDate;

    @LastModifiedBy
    @Column(name = "modified_by", nullable = false, updatable = true)
    private U modifiedBY;

    @LastModifiedDate
    @Column(name = "modified_date", nullable = false, updatable = true)
    private Date modifiedDate;

    public U getCreatedBY() {
        return createdBY;
    }

    public void setCreatedBY(U createdBY) {
        this.createdBY = createdBY;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public U getModifiedBY() {
        return modifiedBY;
    }

    public void setModifiedBY(U modifiedBY) {
        this.modifiedBY = modifiedBY;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Auditable{");
        sb.append("createdBY=").append(createdBY);
        sb.append(", createdDate=").append(createdDate);
        sb.append(", modifiedBY=").append(modifiedBY);
        sb.append(", modifiedDate=").append(modifiedDate);
        sb.append('}');
        return sb.toString();
    }
}
