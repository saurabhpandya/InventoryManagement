package com.inventorymanagement.repository;

import com.inventorymanagement.model.CategoryMaster;
import com.inventorymanagement.model.SupplierMaster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierMasterRepository extends JpaRepository<SupplierMaster, Integer> {
    SupplierMaster findByName(String name);
}
