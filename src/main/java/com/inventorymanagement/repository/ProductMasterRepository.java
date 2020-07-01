package com.inventorymanagement.repository;

import com.inventorymanagement.model.ProductMaster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductMasterRepository extends JpaRepository<ProductMaster, Integer> {
    ProductMaster findByName(String name);
}
