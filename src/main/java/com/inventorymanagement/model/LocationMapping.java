package com.inventorymanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "location_mapping")
public class LocationMapping {
    @Id
    private int id;
    @Column(name = "supplier_customer_id")
    private int supplierCustomerId;
    @Column(name = "address_line_1")
    private String addressLine1;
    @Column(name = "address_line_2")
    private String addressLine2;
    private String area;
    @Column(name = "city_id")
    private int cityId;
    @Column(name = "state_id")
    private int stateId;
    @Column(name = "country_id")
    private int countryId;
    @Column(name = "contact_no")
    private String contactNo;
    private boolean active;
    private boolean deleted;
    private boolean blocked;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSupplierCustomerId() {
        return supplierCustomerId;
    }

    public void setSupplierCustomerId(int supplierCustomerId) {
        this.supplierCustomerId = supplierCustomerId;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public int getStateId() {
        return stateId;
    }

    public void setStateId(int stateId) {
        this.stateId = stateId;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
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
        final StringBuilder sb = new StringBuilder("LocationMapping{");
        sb.append("id=").append(id);
        sb.append(", supplierCustomerId=").append(supplierCustomerId);
        sb.append(", addressLine1='").append(addressLine1).append('\'');
        sb.append(", addressLine2='").append(addressLine2).append('\'');
        sb.append(", area='").append(area).append('\'');
        sb.append(", cityId=").append(cityId);
        sb.append(", stateId=").append(stateId);
        sb.append(", countryId=").append(countryId);
        sb.append(", contactNo='").append(contactNo).append('\'');
        sb.append(", active=").append(active);
        sb.append(", deleted=").append(deleted);
        sb.append(", blocked=").append(blocked);
        sb.append('}');
        return sb.toString();
    }
}
